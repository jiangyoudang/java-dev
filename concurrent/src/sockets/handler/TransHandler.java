package sockets.handler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import sockets.util.Util;

public class TransHandler implements Handler<Socket> {

  @Override
  public void handle(Socket s) throws IOException {
    try (
        Socket socket = s;
        InputStream in = s.getInputStream();
        OutputStream out = s.getOutputStream();
    ) {
      int data;
      while ((data = in.read()) != -1) {
        out.write(Util.trans(data));
      }

    }
  }

}
