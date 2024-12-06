package Thread;

/**
 * @author: Li Yang
 * @date: 2024-12-06
 * @description: 线程顺序执行
 */
public class OrderDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(() -> {
            System.out.println("a");
        });
        Thread b = new Thread(() -> {
            System.out.println("b");
        });
        Thread c = new Thread(() -> {
            System.out.println("c");
        });
        Thread d = new Thread(() -> {
            System.out.println("d");
        });
        a.start();
        a.join();
        b.start();
        b.join();
        c.start();
        c.join();
        d.start();
    }
}
