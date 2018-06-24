package sockets.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ChumpRun {


  public static void main(String[] args) {
    int size = 5000;

    for(int i=0; i < size; i++) {
      try {
        Socket socket = new Socket("localhost", 8080);
        OutputStream out = socket.getOutputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out.write("test ".getBytes());
        out.write("HELLO\n".getBytes());
        System.out.println(in.readLine());
        System.out.println("socket: " + i);
      }catch (IOException e){
        System.out.println("couldn't run more socket connection");
      }

    }
  }

}
