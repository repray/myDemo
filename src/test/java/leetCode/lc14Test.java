package leetCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : liyang
 * @date : 2021/9/16
 *  lc14测试类
 */
class lc14Test {

    @Test
    void testLongestCommonPrefix() {
        String[] strs = {"flower","flow","flight"};
        //assertEquals方法,根据传入的"expected"参数和待测试方法的返回值坐判断,返回测试结果
        assertEquals("fl", new lc14().longestCommonPrefix(strs));
    }
}