package niu.concurrent;

/**
 * Created by Tom on 2016/11/9.
 */
class MyThread extends Thread{
    private int ticket = 50;
    public void run(){
        for (int i=0;i<100;i++)
        {
            if(ticket > 0){
                System.out.println("ticket = " + ticket--);
            }
        }
    }
}

public class ThreadDemo{
    public static void main(String[] args){
        new MyThread().start();
        new MyThread().start();
        new MyThread().start();
    }
}