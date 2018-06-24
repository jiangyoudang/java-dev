package sockets.server;

import sockets.handler.Handler;
import sockets.handler.TransChannelHandler;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.time.Clock;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NIOServer {


  public static void main(String[] args) throws IOException {
    ServerSocketChannel sc = ServerSocketChannel.open();
    sc.bind(new InetSocketAddress(8080));
    sc.configureBlocking(false);

    ExecutorService pool = Executors.newFixedThreadPool(100);
//    Handler<SocketChannel> sockets.handler =
//        new ExecutorServiceHandler<>(new PrintHandler<>(new TransChannelHandler()), pool);
    Handler<SocketChannel> handler = new TransChannelHandler();

    LinkedList<SocketChannel> sockets = new LinkedList<>();

    Clock clock = Clock.systemUTC();
    while (true) {

      SocketChannel s = sc.accept();

      if (s != null) {
        sockets.add(s);
//        System.out.println(clock.instant());
        s.configureBlocking(false);
        System.out.println("connected to " + s);

      }

      System.out.println(sockets.size());

      for (SocketChannel socket : sockets) {
        if (socket.isOpen()) {
//          System.out.println(clock.instant());
          handler.handle(socket);
        } else {
          sockets.remove(socket);
        }
      }
    }
  }

}
