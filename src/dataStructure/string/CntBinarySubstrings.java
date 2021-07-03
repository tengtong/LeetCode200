package dataStructure.string;

/**
 * 统计二进制字符串中连续1和连续0数量相同的子字符串个数
 * Input: "00110011"
 * Output: 6 ("0011","01","1100","10","0011","01")
 */
public class CntBinarySubstrings {
    public int cntBinarySubstrings (String s) {
        int preLen = 0, curLen =1, count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curLen++;
            } else {
                preLen = curLen;
                curLen = 1;
            }
            if (preLen >= curLen) {
                count++;
            }
        }
        return count;
    }
}
