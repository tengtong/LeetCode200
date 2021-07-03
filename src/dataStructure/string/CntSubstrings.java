package dataStructure.string;

/**
 * 统计回文子字符串个数
 * Input: "aaa"
 * Output: 6
 * Explanation: "a","a","a","aa","aa","aaa"
 * 思路： 从字符的某一位开始，尝试去扩展子字符串
 */
public class CntSubstrings {
    private int cnt = 0;

    public int cntSubstrings (String s) {
        //遍历s
        for (int i = 0; i < s.length(); i++) {
            extendSubstrings(s, i, i);//奇数长度，1，3，5，7个等，因为每次循环start--和end++，同时向两边扩展2个数字//(s, i, i)的话肯定能进入一次，也就是至少能记录一次自身
            extendSubstrings(s, i, i + 1);//偶数长度，2，4，6，8等
        }
        return cnt;
    }

    //从字符的某一位开始，去扩展子字符串，start和end都是字符串s的index
    public void extendSubstrings (String s, int start, int end) {
        //当start和end在范围内且s.chartAt(start) == s.chartAt(end) 时，才会进入循环
        //当找到匹配的条件时，start左移，end右移，计数+1
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            cnt++;
        }
    }
}
