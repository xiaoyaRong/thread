package tread;

import sun.tools.jconsole.Tab;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProCon {


    public static void main(String[] args) {
        //ExecutorService executorService = Executors.newFixedThreadPool(2);
        Table table = new Table(5);
        //executorService.execute(new Consumer(table));
        //executorService.execute(new Provider(table));
        //executorService.shutdown();

        new Thread(new Provider(table)).start();
        new Thread(new Consumer(table)).start();
    }




}

class Provider implements Runnable{

    private Table table;

    public Provider(Table table) {
        this.table = table;
    }

    public void run() {
        while (true){
            table.cook();
        }
    }



}

class Consumer implements Runnable{
    private Table table;

    public Consumer(Table table) {
        this.table = table;
    }

    public void run() {

           while (true){
               table.eat();
           }
    }

}


class Cai{
    private int id;

    public Cai(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

class Table{
    //格子
    private Integer size = 5;
    public List<Cai> grid = new ArrayList<Cai>(size);
    private  Integer index = 1;

    public Table(Integer size) {
        this.size = size;
    }

    public Boolean full(){
       if(index.equals(size + 1)){
           return true;
       }
       return false;
    }

    public Boolean empty(){
       if(index == 1){
           return true;
       }
       return false;
    }

    public synchronized void eat(){
        while(!empty()) {
            Cai cai = grid.get(index - 2);
            System.out.println("吃了第" + (index -1 )  +" 盘土豆丝 id" + cai.getId());
            index--;
        }
        notifyAll();
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public synchronized void cook() {
        while (!full()) {
            grid.add(new Cai(index));
            System.out.println("做了第" + index + "盘土豆丝");
            index++;
        }
        this.notifyAll();
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }






}

