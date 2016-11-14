package niu.concurrent;

/**
 * Created by Tom on 2016/11/9.
 */
class MyThreadRunnable implements Runnable{
    private int ticket = 50;
    public void run(){
        for (int i=0;i<100;i++)
        {
            if(ticket > 0){
                try{
                    Thread.sleep(500);
                    //模拟线程不安全，比如可能会出现ticket = 0和ticket = -1的情况
                    //一个线程在判断ticket为1>0后，还没有来得及减1，另一个线程已经将ticket减1，变为了0，那么接下来之前的线程再将ticket减1，便得到了-1。这就需要加入同步操作（即互斥锁）
                    System.out.println("ticket = " + ticket--);
                }catch(InterruptedException e){
                    return;
                }
            }
        }
    }
}

public class RunnableDemo{
    public static void main(String[] args){
        MyThreadRunnable my = new MyThreadRunnable();
        new Thread(my).start();
        new Thread(my).start();
        new Thread(my).start();
    }
}