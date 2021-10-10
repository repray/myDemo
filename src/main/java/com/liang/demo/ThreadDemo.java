package com.liang.demo;

/**
 * @author : liyang
 * @date : 2021/10/10
 */
public class ThreadDemo {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        // MyThread myThread2= new MyThread(); // 2
        Thread t1 = new Thread(myThread);
        Thread t2 = new Thread(myThread);
        // Thread t2= new Thread(myThread2); // 2
        t1.start();
        t2.start();
    }

    public static class MyThread extends Thread {
        // int i=0; // 1
        public void run() {
            String name = Thread.currentThread().getName();
            String inf = Thread.currentThread().toString();
            long idnum = Thread.currentThread().getId();
            for (int i = 0; i < 10; i++) { // 不管是新建一个对象，还是两个对象， // 2，都是打印20个数据
                // for(;i<10;i++){ // 新建一个对象的时候，打印11个左右的数据 ,新建两个对象的时候， // 2，会打印20个数据。 // 1
                System.out.println(" i---------- " + i + " ,thread name== " + name
                        + " ,threadid== " + idnum + " ,thread inf== " + inf);
            }
        }
    }
}
