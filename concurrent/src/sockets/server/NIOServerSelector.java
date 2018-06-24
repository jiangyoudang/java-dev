package sockets.server;

import sockets.handler.AcceptHandler;
import sockets.handler.Handler;
import sockets.handler.ReadHandler;
import sockets.handler.WriteHandler;
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

public class NIOServerSelector {

  public static void main(String[] args) throws IOException {
    ServerSocketChannel sc = ServerSocketChannel.open();
    sc.bind(new InetSocketAddress(8080));
    sc.configureBlocking(false);

    Selector selector = Selector.open();
    sc.register(selector, SelectionKey.OP_ACCEPT);

    Map<SocketChannel, Queue<ByteBuffer>> pendingData = new HashMap<>();

    Handler<SelectionKey> acceptHandler = new AcceptHandler(pendingData);
    Handler<SelectionKey> readHandler = new ReadHandler(pendingData);
    Handler<SelectionKey> writeHandler = new WriteHandler(pendingData);


    while (true) {
      selector.select();
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
