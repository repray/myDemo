package com.liang.demo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Li Yang
 * @Created on 2021/9/8.
 * @Desc
 */
public class hashMapDemo {

    public static void main(String[] args) throws Exception {
        //hashMap在初始化的时候如果没有指定容量,会默认为16,16是hashMap的长度
        Map<String, String> map = new HashMap<>();
        //添加元素的方法
        map.put("小明", "男");
        map.put("小红", "女");
        //size方法为获取当前hashmap已存入的元素
        System.out.println(map.size());
        //get方法,使用key来查找对象,返回结果为value的值,使用index下标的方法不适用于map结构
        System.out.println(map.get(0));
        System.out.println(map.get("小明"));
        //clear清空map中的所有元素
        map.clear();

        //获取hashmap容量和扩容阈值的方法
        //获取HashMap整个类
        Class<?> mapClass = map.getClass();
        //获取指定属性，也可以调用getDeclaredFields()方法获取属性数组
        Field threshold = mapClass.getDeclaredField("threshold");
        //将目标属性设置为可以访问
        threshold.setAccessible(true);
        //获取指定方法，因为HashMap没有容量这个属性，但是capacity方法会返回容量值
        Method capacity = mapClass.getDeclaredMethod("capacity");
        //设置目标方法为可访问
        capacity.setAccessible(true);
        //打印刚初始化的HashMap的容量、阈值和元素数量
        System.out.println("容量：" + capacity.invoke(map) + "  阈值：" + threshold.get(map) + "  元素数量：" + map.size());

    }
}
