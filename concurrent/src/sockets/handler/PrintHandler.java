package sockets.handler;

import java.io.IOException;

public class PrintHandler<S> extends DecoratingHandler<S> {


  public PrintHandler(Handler<S> s) {
    super(s);
  }

  @Override
  public void handle(S s) throws IOException {

    System.out.println("connecting to : "+ s);

    try{
      //
      super.handle(s);
    }finally {
      System.out.println("disconnecting to : "+ s);
    }


  }
}
