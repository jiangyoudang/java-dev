package sockets.handler;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;

public class AcceptHandler implements Handler<SelectionKey> {

  private Map<SocketChannel, Queue<ByteBuffer>> pendingData;
  private ExecutorService pool;

  public AcceptHandler(Map<SocketChannel, Queue<ByteBuffer>> pendingData) {
    this.pendingData = pendingData;
  }

  public AcceptHandler(Map<SocketChannel,Queue<ByteBuffer>> pendingData, ExecutorService pool) {
    this.pendingData = pendingData;
    this.pool = pool;
  }


  @Override
  public void handle(SelectionKey selectionKey) throws IOException {
    ServerSocketChannel ss = (ServerSocketChannel) selectionKey.channel();
    SocketChannel socket = ss.accept();
    socket.configureBlocking(false);
    socket.register(selectionKey.selector(), SelectionKey.OP_READ);
    System.out.println("connection to " + socket);
    if(pool != null) {
      pendingData.put(socket, new ConcurrentLinkedQueue<>());
    }else{
      pendingData.put(socket, new LinkedList<>());
    }

  }
}
