package ThreadPractice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @创建人 StephenLee
 * @创建时间 2018/1/19 11:22
 */
//建立三个线程，交替打印10次ABC
public class Example1 {
    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(new A());
        Thread b = new Thread(new B());
        Thread c = new Thread(new C());
        ExecutorService threadPoolExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0 ; i < 10 ; i++){
            threadPoolExecutor.execute(a);
            threadPoolExecutor.execute(b);
            threadPoolExecutor.execute(c);
        }
        threadPoolExecutor.shutdown();
    }
}

class A implements Runnable{
    @Override
    public void run() {
        System.out.print("A");
    }
}


class B implements Runnable{

    @Override
    public void run() {
        System.out.print("B");
    }
}


class C implements Runnable{

    @Override
    public void run() {
        System.out.print("C");
    }
}
