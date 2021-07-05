package tread;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.concurrent.*;

public class NumberCallable implements Callable<Boolean> {

    public Boolean call() throws Exception {

        for (int i = 20; i > 0; i--) {
            System.out.println(Thread.currentThread().getName() +  "----->" + i);
        }

        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        NumberCallable t1 = new NumberCallable();
        NumberCallable t2 = new NumberCallable();
        NumberCallable t3 = new NumberCallable();
        NumberCallable t4 = new NumberCallable();
        Future<Boolean> submit1 = executorService.submit(t1);
        Future<Boolean> submit2 = executorService.submit(t2);
        Future<Boolean> submit3 = executorService.submit(t3);
        Future<Boolean> submit4 = executorService.submit(t4);
        Future<Boolean> submit5 = executorService.submit(t4);
        Future<Boolean> submit6 = executorService.submit(t4);
        Future<Boolean> submit7 = executorService.submit(t4);
        System.out.println(submit7.get());

        executorService.shutdown();
    }
}
