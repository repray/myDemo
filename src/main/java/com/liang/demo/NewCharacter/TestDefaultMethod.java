package com.liang.demo.NewCharacter;

/**
 * @author : liyang
 * @date : 2021/10/31
 */
public interface TestDefaultMethod {
    void method1(String str);

    //a default method
    default void log(String str) {
        System.out.println("I1 logging::" + str);
    }
}