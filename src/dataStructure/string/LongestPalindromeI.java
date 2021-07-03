package dataStructure.string;

import java.util.*;
/**
 * 输入一个字符串，寻找其中最长的回文串
 */
class LongestPalindromeI {
    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int i;int j;
        int right=0;int left=0;
        int len = s.length();//除了数组length是属性，其他都是方法；
        boolean[][] bp =new boolean[len][len];//基础数据结构也可以new//初始化都是false
        for(i=len-2;i>=0;i--){
            bp[i][i] = true;
            for(j=i+1;j<len;j++){
                bp[i][j] = s.charAt(i)==s.charAt(j) && (j-i<3||bp[i+1][j-1]);
                if(bp[i][j] && right-left<j-i){
                    left = i;
                    right = j;
                }
            }
        }
        System.out.print(s.substring(left,right+1));
    }
}
