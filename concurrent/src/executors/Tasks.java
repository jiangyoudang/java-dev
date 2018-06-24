package executors;

import java.time.Clock;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Tasks {



  public static void main(String[] args) {

    int numOfThread = Runtime.getRuntime().availableProcessors();
    ExecutorService pool = Executors.newFixedThreadPool(numOfThread);
    int numOfTasks = 10;
    Clock clock = Clock.systemUTC();

    Runnable task = () -> {
      String name = Thread.currentThread().getName();

      System.out.println("start delay task "+ name);
      System.out.println(clock.instant());

      Thread.yield();
      try {
        TimeUnit.SECONDS.sleep(3);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      System.out.println("complete task " + name);
    };

    for (int i=0; i< numOfTasks; i++){
      pool.submit(task);
    }

  }

}
