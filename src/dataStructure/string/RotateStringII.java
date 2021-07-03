package dataStructure.string;

/**
 * 字符串循环移位
 * Input: "abcd123", k=3
 * Output: "123abcd"
 */
public class RotateStringII {
    public String solution(String str, int n) {
        int len = str.length();
        if(len == 0) {
            return "";
        }
        n = n % len;//这里有个小细节，因为str=str+str，所以要保证n在[0,len]范围内，整除取个余数
        str += str;
        return str.substring(n,n+len);//substring是[头,尾)，substring是含头不含尾的
    }
}
