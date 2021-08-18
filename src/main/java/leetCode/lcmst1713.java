package leetCode;

import java.lang.reflect.Array;

/**
 * @Author Li Yang
 * @Created on 2021/8/18.
 * @Desc 面试题 17.13. 恢复空格  https://leetcode-cn.com/problems/re-space-lcci/
 */
public class lcmst1713 {

    public static void main(String[] args) {
        String[] dictionary = {"bt","vbtbvtvvbbvtbvvbbbvbtbbv","bvvbbbvvvbvttbtbvtvtvvbttbbbtvvvb","btttbvbbbtbbtbvvttbvbvtvbtbbttb","bt","vvbvbvbvtbvbvvvvtv","tbvvvtttvtbvbtttvvbtvvvvtvvbvvtvvbbvbbbvb","v","bvb","vvtbvtvbttbttvvbvttbt","btbtbtttvbbtbttbtvvttbvtbtvtbvvtbbbb","bttbvbbttvvbtvvvvb","bvvbvbvttbvtbvvtbttvvvvtvbtvbttbbvvtvtvv","vbtttt","btbvbbbvbtvtbvvv","b","tbtbtv","vbvbbvvbvbbvvb","vbvvtvbvbvbttvbvbtvbtbtvtbvbbtb","bvvbvvttttttbtvvvttvbvtvvbvtbtvtbvttvvtbt","bvtbttv","bbbt","vtt","ttvv","b","vbb","vtvvbtttvtbbvvbbtbb","vvv","vvvvbbbtbbbvbbbb","ttvvbtvv","v","btvbbvtbbvbvtvttvvbbbtbvvvtbtb","vv","btbttbtbbvbvvbvttbttvtbbtbvtttvbbtbbtvtvvvvbbttvtvvbbbv","ttvbbbbttbtbtb","tvvbvbvvb","vv","ttbttvtvbtbbbbv","bvvvtbbvvvbtvbvtvtvvvvbb","vtbvvbvvvvvttvbbttbbvtvt","tbvbbt","b","v","tvbbtvvtvvtbtbttvvvb","tbttbttbbbtbtvtvtvtbbbvvtbbbvbbvvvbbttvvt","bbvttvtvvtbvbbttvbbtbvvttbvbvbtbvvvbbbvbvbvbtvbtvvvtvvtbttbttbbvbbbttvvvbvvtb","vttvvbvv","tbttbvvttvbtvvtbbvvv","bvbbbbbbbb","vtbvvtbbvtt","bvttbvvbvb","tvttttbbvvvbbtttvvv"};
        String sentence = "btbvtttttbvttbvvbbtvvbvbvvbtbtbtvbtttbvbbbtbbtbvvttbvbvtvbtbbttbvvbvbtttbvttbvvbbvvv";
        System.out.println(respace(dictionary,sentence));
    }

    /**
     * 感谢力扣有历史记录的功能,找到了之前的提交记录
     * @param dictionary
     * @param sentence
     * @return
     */
    public static int respace(String[] dictionary, String sentence) {
        String[] newDici = new String[dictionary.length];
        StringBuilder sb = new StringBuilder(sentence);
        for (int n = 0; n < dictionary.length - 1; n++) {
            for (int m = 0; m < dictionary.length - n - 1; m++) {
                if (dictionary[m].length() < dictionary[m + 1].length()) {
                    String old = dictionary[m + 1];
                    dictionary[m + 1] = dictionary[m];
                    dictionary[m] = old;
                }
            }
        }

        for (int i = 0; i < dictionary.length; i++) {
            if (sentence.contains(dictionary[i])) {
                newDici[i] = dictionary[i];
                sentence = sentence.replace(dictionary[i], "");
            }
        }
        return sentence.length();
    }
}
