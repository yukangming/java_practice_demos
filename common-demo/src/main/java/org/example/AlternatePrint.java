package org.example;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This is code from Shopee
 */
public class AlternatePrint {

    private static int index = 0;              // shared index for array
    private static int turn = 0;               // which thread should print
    private static final Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {

        int[] arr = {10, 20, 30, 40, 50, 60, 70};
        int nThreads = 3;   // can be any number ≥ 2

        Thread[] threads = new Thread[nThreads];

        for (int i = 0; i < nThreads; i++) {
            int threadId = i;
            threads[i] = new Thread(() -> printTask(arr, nThreads, threadId));
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }
    }

    private static void printTask(int[] arr, int nThreads, int threadId) {
        while (true) {
            lock.lock();
            try {
                while (turn != threadId && index < arr.length) {
                    condition.await();
                }

                if (index >= arr.length) {
                    condition.signalAll();
                    return;
                }

                // Print element
                System.out.println("Thread " + threadId + " → " + arr[index]);

                index++;                // move to next element
                turn = index % nThreads; // next thread's turn

                condition.signalAll();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        }
    }
}

