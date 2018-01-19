package createthreadbyimplementing;

/**
 * @创建人 StephenLee
 * @创建时间 2018/1/19 11:20
 */
public class RunnableDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(new ImplementsRunnable());
        thread.start();
        System.out.println("主线程"+Thread.currentThread().getName()+"结束！");
    }
}

class ImplementsRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("实现implements创建的线程"+Thread.currentThread().getName()+"跑起来了！");
    }
}