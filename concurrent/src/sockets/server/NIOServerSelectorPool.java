package sockets.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import sockets.handler.AcceptHandler;
import sockets.handler.Handler;
import sockets.handler.ReadHandler;
import sockets.handler.WriteHandler;

public class NIOServerSelectorPool {

  public static void main(String[] args) throws IOException {
    int numOfThreads = Integer.getInteger("WORKER_THREADS", Runtime.getRuntime().availableProcessors());
    ExecutorService pool = Executors.newFixedThreadPool(numOfThreads);
    ServerSocketChannel sc = ServerSocketChannel.open();
    sc.bind(new InetSocketAddress(8080));
    sc.configureBlocking(false);

    Selector selector = Selector.open();
    sc.register(selector, SelectionKey.OP_ACCEPT);

    Map<SocketChannel, Queue<ByteBuffer>> pendingData = new ConcurrentHashMap<>();

    Handler<SelectionKey> acceptHandler = new AcceptHandler(pendingData, pool);
    Queue<SocketChannel> toWrite = new ConcurrentLinkedQueue<>();
    Handler<SelectionKey> readHandler = new ReadHandler(pendingData, pool, toWrite);
    Handler<SelectionKey> writeHandler = new WriteHandler(pendingData);


    while (true) {
      selector.select();
      SocketChannel toWriteSocket;
      while((toWriteSocket = toWrite.poll()) != null){
        toWriteSocket.register(selector, SelectionKey.OP_WRITE);
      }
      Set<SelectionKey> keys = selector.selectedKeys();
      for(Iterator<SelectionKey> it = keys.iterator(); it.hasNext();){
        SelectionKey key = it.next();
        if(key.isValid()){
          if(key.isAcceptable()){
            acceptHandler.handle(key);
          }else if(key.isReadable()){
            readHandler.handle(key);
          }else if(key.isWritable()){
            writeHandler.handle(key);
          }

        }

        it.remove();
      }
    }

  }

}
