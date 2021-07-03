package dataStructure.string;

/**
 * 字符串循环移位包含
 * Input: s1=AABCD, s2=CDAA
 * Output: true
 */
public class RotateStringIII {
    public static boolean solution(String str1,String str2){
        String strstr = str1 + str1;
        //contains的实现，可以用双指针，计算完strstr，先匹配左指针，然后向右匹配右指针，如果全部符合就返回true
        boolean res = strstr.contains(str2);
        //或者subString之后，equals判断newStr与str2是否相等
        return res;
    }

    public static void main(String[] args) {
        String str1 = "AABCD";//字符串是双引号，字符是单引号
        String str2 = "CDAA";
        System.out.println(solution(str1, str2));
    }
}
