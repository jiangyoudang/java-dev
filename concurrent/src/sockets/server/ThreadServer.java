package sockets.server;

import sockets.handler.Handler;
import sockets.handler.PrintHandler;
import sockets.handler.ThreadHandler;
import sockets.handler.TransHandler;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadServer {


  public static void main(String[] args) throws IOException {
    ServerSocket ss = new ServerSocket(8080);
    Handler<Socket> handler = new ThreadHandler<>(new PrintHandler<>(new TransHandler()));
    while (true) {
      Socket s = ss.accept();
      handler.handle(s);
    }
  }

}
