package dataStructure.string;
import java.util.*;

/**
 * 反转字符串
 */
public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] res = s.split("");

        //从头往后逐位交换，交换到数组的一半长度就可以了
        for(int i=0;i<res.length/2;i++){
            String temp = res[i];
            res[i] = res[res.length-1-i];
            res[res.length-1-i] = temp;
        }
        //遍历输出一般都是forEach实现的
        for(String re:res){
            System.out.print(re);//别的方法的toString，例如Arrays.toString是将整个数组转成一个String，然后输出一个String字符串的形式实现的
        }
    }
}
//    int len = s.length();//length()是String的方法
//    int len1 = arr.length;//length是数组的属性