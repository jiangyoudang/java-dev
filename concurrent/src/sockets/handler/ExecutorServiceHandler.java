package sockets.handler;

import java.util.concurrent.ExecutorService;

public class ExecutorServiceHandler<S> extends DecoratingHandler<S> {

  private final ExecutorService pool;

  public ExecutorServiceHandler(Handler<S> s, ExecutorService pool) {
    super(s);
    this.pool = pool;
  }

  @Override
  public void handle(S s) {

    pool.submit(getRunFunc(s));
  }
}
