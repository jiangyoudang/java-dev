package sockets.server;

import sockets.handler.Handler;
import sockets.handler.PrintHandler;
import sockets.handler.TransHandler;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleServer{


  public static void main(String[] args) throws IOException {
    ServerSocket ss = new ServerSocket(8080);
    while (true) {
      Socket s = ss.accept();
      Handler<Socket> handler = new PrintHandler<>(new TransHandler());
      handler.handle(s);
    }
  }

}
