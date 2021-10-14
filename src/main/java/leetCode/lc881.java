package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Li Yang
 * @Created on 2021/8/26.
 * @Desc 881. 救生艇  https://leetcode-cn.com/problems/boats-to-save-people/
 * 未过测试,待完善
 */
public class lc881 {

    public static void main(String[] args) {
        int[] people = {3, 2, 2, 1};
        int limit = 3;
        System.out.println(numRescueBoats(people, limit));
//        System.out.println();
    }

    public static int numRescueBoats(int[] people, int limit) {
        int result = people.length;
        List<Integer> peopleList = new ArrayList<>();
        for (int person : people) {
            peopleList.add(person);
        }
        for (int i = 0; i < peopleList.size() - 1; i++) {

            for (int j = 0; j < peopleList.size() - 1 - j; j++) {
                if (peopleList.get(i) + peopleList.get(j) <= limit) {
                    result--;
                    peopleList.remove(i);
                    peopleList.remove(j);
                }
            }
        }
        return result;
    }
}
