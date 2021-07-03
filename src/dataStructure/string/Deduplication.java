package dataStructure.string;

import java.util.Scanner;

/**
 * 给定一个字符串，将重复的字符去除，仅保留第一次出现的字符，且保持去重后的字符在原字符串中的顺序不变
 * 方法一：遍历字符数组，hashmap，当value==0时，才存入newArr
 * 方法二：检查字符的第一次和最后一次出现的索引位置，判断后添存入新数组
 */
public class Deduplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String res = Deduplication.helper(s);
        System.out.println(res);
    }
    public static String helper(String s){
        if(s==null){
            return s;
        }
        StringBuffer sb = new StringBuffer();//因为String是对象不可变，是常量，没有append方法
        for(int i=0;i<s.length();i++){
            char everyWord = s.charAt(i);
            int firstIndex = s.indexOf(everyWord);//返回该字符在字符串中第一次出现处的索引，若无则返回-1
            int lastIndex = s.lastIndexOf(everyWord);//返回该字符在字符串中最后一次出现处的索引
            if(lastIndex == firstIndex || firstIndex == i ){
                sb.append(everyWord);//StringBuffer和StringBuilder是继承的AbstractStringBilder，对象都是可变的，故有append方法
                                     //StringBuffer在基础上加了"锁"，是线程安全的
            }
        }
        return sb.toString();
    }
}
