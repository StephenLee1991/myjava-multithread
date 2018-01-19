package createthreadbyextending;

/**
 * @创建人 StephenLee
 * @创建时间 2018/1/19 11:10
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Thread thread = new ExtendsThread();
        thread.start();
        System.out.println("主线程"+Thread.currentThread().getName()+"结束！");
    }
}

class ExtendsThread extends Thread {
    @Override
    public void run() {
        System.out.println("通过继承Thread创建的线程跑起来了！线程名称是："+Thread.currentThread().getName());
    }
}
