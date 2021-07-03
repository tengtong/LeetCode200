package algorithm.doublePointer;

/**
 * 可以删除一个字符，判断是否能构成回文字符串
 */
public class ValidPalindrome {
    //注意：这里我们不需要重新判断整个字符串，因为两边已经判断过了，删除i或者j时，我们只要判断[i,j-1]或[i+1,j]是否能构成回文串即可
    //这种特殊的方法也依赖与只删除一个元素的操作，删除多个的话新数组不容易确定
    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
        }
        return true;
    }
    //回文串判断，双指针，头尾相同
    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
