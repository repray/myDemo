package com.liang.demo;

import org.springframework.boot.SpringBootVersion;
import org.springframework.core.SpringVersion;

/**
 * 查看spring版本号
 */
public class checkSpringVersion {

    public static void main(String[] args) {
        String sVersion = SpringVersion.getVersion();
        System.out.println("Spring 版本号：" + sVersion);
        String bVersion = SpringBootVersion.getVersion();
        System.out.println("SpringBoot 版本号：" + bVersion);
    }
}
