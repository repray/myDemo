package leetCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : liyang
 * @date : 2021/9/16
 */
class lc14Test {

    @Test
    void testLongestCommonPrefix() {
        String[] strs = {"flower","flow","flight"};
        assertEquals("fl", new lc14().longestCommonPrefix(strs));
    }
}