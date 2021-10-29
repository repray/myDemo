package com.liang.demo.NewCharacter;

/**
 * @author Li Yang
 * @date 2021/10/29
 * JDK新特性-自动拆装箱包装类
 */
public class AutoPackingDevanning {
    public static void main(String[] args) {
        
        boolean flag = new Boolean(true);
        System.out.println("Boolean 转 boolean ： " + flag);
        Boolean bFlag = false;
        System.out.println("boolean 转 Boolean ： " + bFlag);
        int i = new Integer(1);
        System.out.println("Integer 转 int ： " + i);
        Integer integer = 2;
        System.out.println("int 转 Integer ： " + integer);

    }
}
