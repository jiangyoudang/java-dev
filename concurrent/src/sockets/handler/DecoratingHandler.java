package sockets.handler;

import java.io.IOException;

public abstract class DecoratingHandler<S> implements Handler<S> {
  
  public Handler<S> decorateHandler;
  
  
  @Override
  public void handle(S s) throws IOException {
    this.decorateHandler.handle(s);
  }

  public DecoratingHandler(Handler<S> s) {
    this.decorateHandler = s;
  }

  public Runnable getRunFunc(S s){

    return () -> {
      try{
        Thread thread = Thread.currentThread();
        System.out.printf("running at thread: %s (%d) \n", thread.getName(), thread.getId());

        this.decorateHandler.handle(s);
      } catch (IOException e){
        System.out.println("error: " + s);
      }
    };
  }


}
