package algorithm.math.other;

/**
 * 不用四则运算，实现加法
 * 从位运算下手
 */
public class Add {
    public int add(int num1,int num2) {//num1、num2原为两个数，方法中num1是两数字加法值，num2是两数进位值
        //例如有多位进位，则会有多次进位，例如121+979
        while (num2!=0) {//进位值为非空时跳出循环
            int temp = num1^num2;//"异或"操作求得是各位相加值num1
            num2 = (num1&num2)<<1;//"与"操作求得是进位值num2
            num1 = temp;//当无进位值时，加法值就是最后的结果
        }
        return num1;
    }
}
