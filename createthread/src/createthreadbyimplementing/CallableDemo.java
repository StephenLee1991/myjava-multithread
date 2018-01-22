package createthreadbyimplementing;

import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @创建人 StephenLee
 * @创建时间 2018/1/22 13:09
 */
public class CallableDemo {
    public static void main(String[] args) throws Exception {
        //通过futureTask容器将实现了Callable接口的类包装起来
        Callable<Object> callable = new ImplementsCallable();
        FutureTask futureTask = new FutureTask<>(callable);
        //将FutureTask对象添加到线程中
        Thread thread = new Thread(futureTask);
        //启动线程
        thread.start();
        //获取调用线程后的返回值
        System.out.println(futureTask.get());
    }
}

class ImplementsCallable implements Callable<Object>{
    @Override
    public Object call() throws Exception {
        Scanner scanner = new Scanner(System.in);
        String result = scanner.next();
        if("yes".equals(result)){
           return "yes";
        }
       return "no";
    }
}
