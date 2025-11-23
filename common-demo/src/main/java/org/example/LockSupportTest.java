package org.example;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * 看起来LockSupport的park和unPark方法，都会获取到当前的线程，然后给线程阻塞或者放行；
 * 而且park方法类似信获取信号量，unPark方法类似释放信号量；令人惊讶地是，park方法和unPark
 * 方法的先后顺序似乎不再重要，只要保证对一个线程执行成对的park和unPark方法即可让线程正常执行
 */
public class LockSupportTest {

    private static final Object mutex = new Object();

    @Data
    static class ThreadExample implements Runnable {

        private AtomicInteger count;

        private String name;

        @Override
        public void run() {
            synchronized (mutex) {

                System.out.println("先执行一下unPark试试");
                LockSupport.unpark(Thread.currentThread());
                System.out.println("现在运行的是" + getName() + "线程");
                System.out.println("第" + getCount().getAndIncrement() + "次运行");
                LockSupport.park();

                System.out.println("执行park方法后");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ThreadExample threadExample = new ThreadExample();

        ThreadExample threadExample1 = new ThreadExample();

        threadExample.setName("t1hhh");
        threadExample.setCount(new AtomicInteger(1));
        threadExample1.setName("t1hhhh");
        Thread t1hhhh = new Thread(threadExample, "t1hhhh");

        t1hhhh.start();

//         这里可以看出，不能调用多次start方法，不然会抛出IllegalThreadStateException
//        t1hhhh.start();
//        t1hhhh.start();
        Thread.sleep(10000);
        Thread t1hhhh1 = new Thread(threadExample1, "t1hhhh");
        t1hhhh1.start();
        LockSupport.unpark(t1hhhh);
        LockSupport.unpark(t1hhhh1);

//         这里仅仅是为了等这两个子线程完成之后打印主线程的语句
        t1hhhh.join();
        t1hhhh1.join();

        System.out.println("主函数等待两个线程都执行完park和unPark方法咯");
    }

}
