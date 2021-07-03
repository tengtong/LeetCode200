package dataStructure.string;
import java.util.*;

/**
 * 回转字符串
 */
public class RotateStringI {
    public String solution1(String str,int n){
        str = (str+str).substring(n,n+str.length());//beginIndex（包括）从0开始，endIndex（不包括）
        return str;
    }

    public boolean solution2(String str1,String str2){
        boolean res = (str1+str1).contains(str2);
        return res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);//只要一次就行
        String str = sc.next();//相当于一次输入
        RotateStringI rs = new RotateStringI();
        int n = sc.nextInt();//相当于一次输入
        String res =  rs.solution1(str,n);
        System.out.println(res);

//        String str2 = sc.next();
//        boolean b = rs.solution2(str,str2);
//        System.out.println(b);
    }
}