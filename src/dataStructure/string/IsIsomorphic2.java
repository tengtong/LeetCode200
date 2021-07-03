package dataStructure.string;

import java.util.*;

/**
 * 判断两个字符串是否同构
 * 思路：用256位数组记录，出现字符的次数，类同hashMap，但是这里不仅是记录出现元素的个数，还与出现元素的顺序/位置有关，即用i+1代替++1统计
 */
public class IsIsomorphic2 {
    public boolean isIsomorphic2 (String s, String t) {
        int[] preIndexOfS = new int[256];
        int[] preIndexOfT = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (preIndexOfS[sc] != preIndexOfT[tc]) {
                return false;
            }
            preIndexOfS[sc] = i + 1;
            preIndexOfT[tc] = i + 1;
        }
        return true;
    }
}
//hashMap是存完之后再比较，不是一边存一边比较，故方法不便，不推荐
