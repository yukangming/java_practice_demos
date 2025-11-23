package org.example;

import java.awt.print.Printable;
import java.util.concurrent.locks.LockSupport;

public class MultiplePrintTest {


    private static volatile int count = 0;

    static Thread thread1,thread2,thread3;

     static class PrintTread1 implements Runnable {
        public void run() {
            while(true) {
                while (count % 3 != 0) {
                    LockSupport.park();
                }

                System.out.println("A");
                count++;
                LockSupport.unpark(thread2);
            }
        }
    }

    static class PrintTread2 implements Runnable {
        public void run() {
            while(true) {
                while (count % 3 != 1) {

                    LockSupport.park();
                }

                System.out.println("B");
                count++;
                LockSupport.unpark(thread3);
            }
        }
    }

    static class PrintTread3 implements Runnable {
        public void run() {
            while(true) {
                while (count % 3 != 2) {
                    LockSupport.park();
                }

                System.out.println("C");
                count++;
                LockSupport.unpark(thread1);
            }
        }
    }




    public static void main(String[] args) {
        thread1 = new Thread(new PrintTread1());
        thread2 = new Thread(new PrintTread2());
        thread3 = new Thread(new PrintTread3());

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
