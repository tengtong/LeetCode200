package dataStructure.string;

import java.util.*;
/**
 * 数值型字符串转成数字
 * 例如：
 * 输入：+123，输出：123
 * 输入：-123，输出：-123
 * 输入：123，输出：123
 * 输入：+1a23，输出：0
 */
public class IntegerValueOf {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();//输入一个字符串
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[] charToInt = new int[len];
        int res = 0;
        int flag = 1;
        int beginIndex = 0;
        //考虑
        if(chars[0]=='+' || chars[0]=='-') {
            beginIndex = 1;
        }
        else if ('0'<=chars[0] && chars[0]<='9') {
            beginIndex = 0;
        }else{
            flag = 0;
        }
        if(flag == 1){
            for(int i=beginIndex;i<len;i++) {
                if ('0'<=chars[i] && chars[i]<='9'){
                    charToInt[i] = chars[i]-'0';
                }
                else{
                    flag = 0;
                    break;
                }
            }
            int location = 1;
            for(int j=len-1;j>=0;j--){
                res += charToInt[j]*location;
                location *=10;
            }
            if (chars[0]=='-'){
                res = -res;
            }
        }
        System.out.print(flag==1?res:0);
    }
}
