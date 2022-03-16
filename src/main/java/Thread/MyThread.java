package Thread;

/**
 * @author : liyang
 * @date : 16/3/2022
 * 继承Thread类,重写run方法,创建对象实现多线程的写法
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i <= 500; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        //start和run的区别,调用run方法,会看到依次的0-500的输出,然后再一次0-500的输出,说明是t1方法执行完再执行t2
        //调用start方法,会看到第一次500的输出之前就已经出现了第二次0-500之间数字的数据,这说明是t1线程开始执行,然后调用t2线程执行,并不是方法顺序调用的结果
        t1.run();
        t2.run();
        t1.start();
        t2.start();
    }

}
