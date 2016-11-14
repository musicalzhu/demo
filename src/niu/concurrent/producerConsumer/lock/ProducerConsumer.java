package niu.concurrent.producerConsumer.lock;

/**
 * Created by Tom on 2016/11/9.
 */
import java.util.concurrent.locks.*;

class Info { // 定义信息类
    private String name = "name";//定义name属性，为了与下面set的name属性区别开
    private String content = "content" ;// 定义content属性，为了与下面set的content属性区别开
    private boolean flag = true ;   // 设置标志位,初始时先生产
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition(); //产生一个Condition对象
    public  void set(String name,String content){
        lock.lock();
        try{
            while(!flag){
                condition.await() ;
            }
            this.setName(name) ;    // 设置名称
            Thread.sleep(300) ;
            this.setContent(content) ;  // 设置内容
            flag  = false ; // 改变标志位，表示可以取走
            condition.signal();
        }catch(InterruptedException e){
            e.printStackTrace() ;
        }finally{
            lock.unlock();
        }
    }

    public void get(){
        lock.lock();
        try{
            while(flag){
                condition.await() ;
            }
            Thread.sleep(300) ;
            System.out.println(this.getName() +
                    " --> " + this.getContent()) ;
            flag  = true ;  // 改变标志位，表示可以生产
            condition.signal();
        }catch(InterruptedException e){
            e.printStackTrace() ;
        }finally{
            lock.unlock();
        }
    }

    public void setName(String name){
        this.name = name ;
    }
    public void setContent(String content){
        this.content = content ;
    }
    public String getName(){
        return this.name ;
    }
    public String getContent(){
        return this.content ;
    }
}
class Producer implements Runnable{ // 通过Runnable实现多线程
    private Info info = null ;      // 保存Info引用
    public Producer(Info infoLock){
        this.info = infoLock ;
    }
    public void run(){
        boolean flag = true ;   // 定义标记位
        for(int i=0;i<10;i++){
            if(flag){
                this.info.set("姓名--1","内容--1") ;    // 设置名称
                flag = false ;
            }else{
                this.info.set("姓名--2","内容--2") ;    // 设置名称
                flag = true ;
            }
        }
    }
}
class Consumer implements Runnable{
    private Info info = null ;
    public Consumer(Info info){
        this.info = info ;
    }
    public void run(){
        for(int i=0;i<10;i++){
            this.info.get() ;
        }
    }
}
public class ProducerConsumer {
    public static void main(String args[]){
        Info info = new Info(); // 实例化Info对象
        Producer pro = new Producer(info) ; // 生产者
        Consumer con = new Consumer(info) ; // 消费者
        new Thread(pro).start() ;
        //启动了生产者线程后，再启动消费者线程
        try{
            Thread.sleep(500) ;
        }catch(InterruptedException e){
            e.printStackTrace() ;
        }

        new Thread(con).start() ;
    }
}