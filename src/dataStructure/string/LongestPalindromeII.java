package dataStructure.string;

/**
 * 计算一组字符集可以组成的回文字符串的最大长度
 * Input: "abccccdd"
 * Output: 7 ("dccaccd")
 * 思路：使用长度为256的整型数组来统计每个字符出现的个数，当出现偶数个字符的时候，可以用来构成回文字符串，若是奇数个，可以放在中间
 */
public class LongestPalindromeII {
    public int longestPalindrome(String s){
        int[] cnts = new int[256];
        for (char c: s.toCharArray()){
            cnts[c]++;//这里是256位不是26位的，故不用 -'a'
        }
        int palindrome = 0;
        for (int cnt : cnts){
            palindrome += (cnt / 2) * 2;//先整除，(3/2)*2=2，表示有3个那么可以拿2个做回文串
        }
        if (palindrome < s.length()) {//如果最终回文串的长度比总长度短，那么表示在上式中出现奇数个个数时，例如3个，只取了2个，那么可以往中间位置加一个元素
            palindrome++;//这个条件下s中一定有单个未使用的字符存在，可以把这个字符放到回文的最中间
        }
        return palindrome;
    }
}
