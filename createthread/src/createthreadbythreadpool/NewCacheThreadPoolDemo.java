package createthreadbythreadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @创建人 StephenLee
 * @创建时间 2018/1/23 16:21
 */
public class NewCacheThreadPoolDemo {
    public static void main(String[] args) {
        //创建newCachedThreadPool线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //通过execute（线程）执行线程
        executorService.execute(new ThreadPoolRunnableTest());
        //线程池使用完毕关闭线程
        executorService.shutdown();
    }
}

class ThreadPoolRunnableTest implements Runnable{

    @Override
    public void run() {
        System.out.println("通过线程池启动线程！");
    }
}
