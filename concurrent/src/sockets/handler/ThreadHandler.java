package sockets.handler;

public class ThreadHandler<S> extends DecoratingHandler<S> {


  public ThreadHandler(Handler<S> s) {
    super(s);
  }

  @Override
  public void handle(S s) {
    new Thread(getRunFunc(s)).start();
  }
}
