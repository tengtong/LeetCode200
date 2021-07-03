package algorithm.greedy;

/**
 * 判断是否为子序列
 * s = "abc", t = "ahbgdc"
 * Return true.
 */
//TODO
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }
}
