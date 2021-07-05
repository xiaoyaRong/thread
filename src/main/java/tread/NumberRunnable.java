package tread;

public class NumberRunnable implements Runnable {



    public static void main(String[] args){
        NumberRunnable numberRunnable = new NumberRunnable();
        new Thread(numberRunnable,"李华").start();
        new Thread(numberRunnable,"小明").start();

    }

    public void run() {
        for (Integer i = 2000; i > 0; i--) {
                System.out.println( Thread.currentThread().getName() + "---->"  + i);
        }
    }
}
