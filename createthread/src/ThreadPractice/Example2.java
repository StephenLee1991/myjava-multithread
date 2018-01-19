package ThreadPractice;

/**
 * @创建人 StephenLee
 * @创建时间 2018/1/19 14:36
 */

//建立三个线程，A线程打印10次A，B线程打印10次B,C线程打印10次C，要求线程同时运行，交替打印10次ABC
public class Example2 {
    public static void main(String[] args) throws InterruptedException {
       Object a = new Object();
       Object b = new Object();
       Object c = new Object();
        //创建线程
       PrintOrder pa = new PrintOrder("A",c,a);
       PrintOrder pb = new PrintOrder("B",a,b);
       PrintOrder pc = new PrintOrder("C",b,c);
        //启动线程顺序打印ABC
       new Thread(pa).start();
       Thread.sleep(1000);
       new Thread(pb).start();
       Thread.sleep(1000);
       new Thread(pc).start();

    }
}

class PrintOrder implements Runnable{
    private String name;
    private final Object pre;
    private final Object self;
    PrintOrder(String name, Object pre, Object self) {
        this.name = name;
        this.pre = pre;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 10;
        while (count>0){
            synchronized (pre){//给上一个对象加锁
                synchronized (self){//当前对象加锁

                    count--;
                    System.out.println(Thread.currentThread().getName()+":"+name+"剩余次数"+count);


                    self.notify();//唤醒当前线程
                }
                try {
                    pre.wait();//让上一个线程阻塞等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}