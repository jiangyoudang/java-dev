package sockets.server;

import sockets.handler.ExecutorServiceHandler;
import sockets.handler.Handler;
import sockets.handler.PrintHandler;
import sockets.handler.TransHandler;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServer {


  public static void main(String[] args) throws IOException {
    ServerSocket ss = new ServerSocket(8080);
      ExecutorService pool = Executors.newFixedThreadPool(100);
//    ExecutorService pool = Executors.newCachedThreadPool();
      Handler<Socket> handler = new ExecutorServiceHandler<>(new PrintHandler<>(new TransHandler()),
          pool);
      while (true) {
        Socket s = ss.accept();
        handler.handle(s);
      }
  }

}
