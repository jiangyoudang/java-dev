package sockets.handler;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import sockets.util.Util;

public class ReadHandler implements Handler<SelectionKey> {

  private Map<SocketChannel, Queue<ByteBuffer>> pendingData;
  private ExecutorService pool;
  private Queue<SocketChannel> toWrite;

  public ReadHandler(Map<SocketChannel, Queue<ByteBuffer>> pendingData) {
    this.pendingData = pendingData;
  }

  public ReadHandler(Map<SocketChannel,Queue<ByteBuffer>> pendingData,
      ExecutorService pool, Queue<SocketChannel> toWrite) {
    this.pendingData = pendingData;
    this.pool = pool;
    this.toWrite = toWrite;
  }


  @Override
  public void handle(SelectionKey selectionKey) throws IOException {
    SocketChannel socket = (SocketChannel) selectionKey.channel();
    ByteBuffer buffer = ByteBuffer.allocate(80);
    int read = socket.read(buffer);
    System.out.println("read socket: " + socket);
    if(read == -1){
      socket.close();
      pendingData.remove(socket);
    }else{
      if(pool != null){
        pool.submit(() -> {
          Util.trans(buffer);
          pendingData.get(socket).add(buffer);
          selectionKey.selector().wakeup();
          toWrite.add(socket);
        });
      }else{
        Util.trans(buffer);
        pendingData.get(socket).add(buffer);
        selectionKey.interestOps(SelectionKey.OP_WRITE);
      }

    }




  }
}
