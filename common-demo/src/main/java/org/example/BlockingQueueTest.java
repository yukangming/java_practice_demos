package org.example;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {


    static class Producer implements Runnable {

        private BlockingQueue queue;

        public Producer(BlockingQueue queue) {
            this.queue = queue;
        }


        @Override
        public void run() {
            try {
                queue.put(1);
                Thread.sleep(1000);
                queue.put(2);
                Thread.sleep(1000);
                queue.put(3);
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    static class Consumer implements Runnable {

        private BlockingQueue queue;


        public Consumer(BlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                System.out.println(queue.take());
                System.out.println(queue.take());
                System.out.println(queue.take());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> integers = new ArrayBlockingQueue<>(1024);

        Producer producer = new Producer(integers);
        Consumer consumer = new Consumer(integers);
        new Thread(producer).start();
        new Thread(consumer).start();

        Thread.sleep(4000);
        // 下面会抛出错误，无法通过这种方式拿到unsafe实例
//        Unsafe unsafe = Unsafe.getUnsafe();
//        System.out.println("可以用这种方式拿到unsafe实例" + unsafe);

    }
}
