package dataStructure.string;

import java.util.*;
/**
 * 验证回文串
 */
public class IsPalindrome {
    public boolean isPalindrome1 (String s) {
        char[] chars = s.toCharArray();
        boolean res = true;
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {//如果涉及
                res = false;
                break;
            }
        }
        return res;
    }
}
//boolean b = Character.isLetter('中');
//这里可以用清除非字母类型的符号，例如：','、'.'、';'等非字母
//isLetter来判断是否是字母，但是不识别中文