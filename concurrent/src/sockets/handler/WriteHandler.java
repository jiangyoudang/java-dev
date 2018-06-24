package sockets.handler;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.Map;
import java.util.Queue;

public class WriteHandler implements Handler<SelectionKey> {

  private Map<SocketChannel, Queue<ByteBuffer>> pendingData;

  public WriteHandler(Map<SocketChannel, Queue<ByteBuffer>> pendingData) {
    this.pendingData = pendingData;
  }

  @Override
  public void handle(SelectionKey selectionKey) throws IOException {
    SocketChannel socket = (SocketChannel) selectionKey.channel();
    System.out.println("write data: " + socket);
    Queue<ByteBuffer> queue = pendingData.get(socket);

    while (!queue.isEmpty()){
      ByteBuffer buffer = queue.peek();

      int written = socket.write(buffer);
      if(written == -1){
        socket.close();
        pendingData.remove(socket);
        return;
      }

     if(!buffer.hasRemaining()) {
        queue.remove();
     }else {
        return;
     }
    }
    selectionKey.interestOps(SelectionKey.OP_READ);


  }
}
