package com.liang.demo;

import entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Author Li Yang
 * @Created on 2021/10/11.
 * @Desc jdk新特性
 */
public class JDKNewCharacter {

    public static void main(String[] args) {

        //stream.filter一般适用于list集合,主要作用就是模拟sql查询，从集合中查询想要的数据。filter里面的参数user是指集合里面的每一项
        List<User> list = new ArrayList<>();
        //定义三个用户对象
        User user1 = new User();
        user1.setName("praye");
        user1.setPassword(123456);
        User user2 = new User();
        user2.setName("liness");
        user2.setPassword(234567);
        User user3 = new User();
        user3.setName("txvo");
        user3.setPassword(456789);
        //添加用户到集合中
        list.add(user1);
        list.add(user2);
        list.add(user3);

        //在集合中查询用户名为praye的集合
        List<User> userList = list.stream().filter(user -> "praye".equals(user.getName())).collect(Collectors.toList());
        //在集合中查询出第一个用户密码为123456的用户
        Optional<User> user = list.stream().filter(userTemp -> userTemp.getPassword().equals(123456)).findFirst();

        System.out.println(userList);
        System.out.println(user);
    }

}
