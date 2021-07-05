package tread;

public class NumberThread  extends Thread {

    @Override
    public void run() {
        for (int i = 20; i > 0; i--) {
            System.out.println(i);
        }

    }

    public static void main(String[] args){
        new NumberThread().start();
        new NumberThread().start();
        new NumberThread().start();
    }
}
