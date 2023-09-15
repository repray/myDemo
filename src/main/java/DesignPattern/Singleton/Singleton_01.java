package DesignPattern.Singleton;

/**
 * 单例模式-懒汉式
 */
public class Singleton_01 {
    private static Singleton_01 instance;
    private Singleton_01() {
    }
    public static Singleton_01 getInstance(){
        if (null != instance) return instance;
        instance = new Singleton_01();
        return instance;
    }
}
/**
 * 单例模式有一个特点就是不允许外部直接创建，也就是 new Singleton_01() ，因此这里在默认
 * 的构造函数上添加了私有属性private 。
 * 目前此种⽅方式的单例例确实满足了懒加载，但是如果有多个访问者同时去获取对象实例,你可以想象成
 * 一堆人在抢厕所,就会造成多个同样的实例并存,从而没有达到单例的要求。
 */