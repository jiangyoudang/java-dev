package sockets.handler;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import sockets.util.Util;

public class TransChannelHandler implements Handler<SocketChannel> {

  @Override
  public void handle(SocketChannel s) throws IOException {
    ByteBuffer buff = ByteBuffer.allocate(80);

//    System.out.println("handling socket "+ s);
//    while (s.isOpen()){
      int read = s.read(buff);
      if(read == -1) {
        s.close();
      }else if(read !=0 ){
        Util.trans(buff);
        System.out.println(new String(buff.array(), 0, buff.limit()));
        s.write(buff);
        buff.clear();
      }

//    }




  }

}
