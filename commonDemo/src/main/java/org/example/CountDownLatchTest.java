package org.example;

import java.util.concurrent.CountDownLatch;

/**
 * 这是用来看一下CountDownLatch的具体作用的例子
 * await方法会等到CountDownLatch中state== 0 之后才会继续执行
 * countDown方法其实内部是release方法，减少state值
 */
public class CountDownLatchTest {


    static class FirstBatchWorker implements Runnable {
        private CountDownLatch countDownLatch;

        public FirstBatchWorker(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            System.out.println("First batch executed!");

            countDownLatch.countDown();
            System.out.println("during first batch countDownBatch.getCount() = " + countDownLatch.getCount());
        }
    }

    static class SecondBatchWorker implements Runnable {

        private CountDownLatch countDownLatch;

        public SecondBatchWorker(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }


        @Override
        public void run() {
            try {
                countDownLatch.await();
                System.out.println("second batch countDownBatch.getCount() = " + countDownLatch.getCount());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 5; i++) {
            new Thread(new FirstBatchWorker(countDownLatch)).start();

        }

        for (int i = 0; i < 5; i++) {
            new Thread(new SecondBatchWorker(countDownLatch)).start();

        }

        while (countDownLatch.getCount() != 1) {
            Thread.sleep(100L);
        }

        System.out.println("wait for first batch executed! and countDownLatch.getCount() == " + countDownLatch.getCount());
        countDownLatch.countDown();
    }
}
