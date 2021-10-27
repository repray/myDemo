package com.liang.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Li Yang
 * @Created on 2021/10/25.
 * @Desc
 */
public class arrDemo {

    public static void main(String[] args) {
        List<Long> oldClassIds = new ArrayList<>();
        oldClassIds.add(1L);
        oldClassIds.add(2L);
        oldClassIds.add(3L);
        oldClassIds.add(4L);
        List<Long> nowClassIds = new ArrayList<>();
        nowClassIds.add(4L);
        nowClassIds.add(5L);
        nowClassIds.add(6L);
        nowClassIds.add(7L);
        List<Long> addArr = new ArrayList<>();
        List<Long> removeArr = new ArrayList<>();


        for (Long oldId : oldClassIds) {
            boolean has = false;
            for (Long nowId : nowClassIds) {
                if (nowId.equals(oldId)) {
                    has = true;
                    break;
                }
            }

            if (!has) {
                removeArr.add(oldId);
            }
        }

        //刨除要移除关系的班级，其他的班都作为添加关系的班级
        for (Long nowId : nowClassIds) {
            if (removeArr.contains(nowId)) {
                continue;
            }
            addArr.add(nowId);
        }

        System.out.println("_______");
    }

}
