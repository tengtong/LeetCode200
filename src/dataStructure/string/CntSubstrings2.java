package dataStructure.string;

/**
 * 最长回文子串
 * 思路：用两个函数去做，辅助函数的作用是
 */
public class CntSubstrings2 {

    private int cnt = 0;

    //主函数
    public int cntSubstrings2(String s) {
        for (int i = 0; i < s.length(); i++) {
            //奇数长度字符的统计，因为循环会执行start—-和end++，所以是每次同时向两边拓展两个位置
            extendSubstrings(s, i, i);
            extendSubstrings(s, i, i + 1);
        }
        return cnt;
    }

    //辅助函数：用来在基于[i]或者[i,i+1]的基础坐标上统计存在的回文子串的个数，所以不会出现重复的情况
    public void extendSubstrings(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            cnt++;
        }
    }
}
