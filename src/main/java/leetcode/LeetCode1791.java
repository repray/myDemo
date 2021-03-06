package leetcode;

/**
 * @Author Li Yang
 * @Created on 18/2/2022.
 * @Desc link: https://leetcode-cn.com/problems/find-center-of-star-graph/
 */
public class LeetCode1791 {
    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {2, 3}, {4, 2}};
        System.out.println(findCenterUpdate(edges));
    }

    //普通算法
    public static int findCenter(int[][] edges) {
        int result = 0;
        for (int i = 0; i < edges.length; i++) {
            result = edges[i][0];
            if (edges[i + 1][0] != result && edges[i + 1][1] != result) {
                result = edges[i][1];
                break;
            }
        }
        return result;
    }

    //修改后算法
    public static int findCenterUpdate(int[][] edges) {
        return (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) ? edges[0][0] : edges[0][1];
    }
}
