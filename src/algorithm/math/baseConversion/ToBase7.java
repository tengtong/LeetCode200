package algorithm.math.baseConversion;

/**
 * 7进制
 */
//TODO
public class ToBase7 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        boolean isNegative = num < 0;
        if (isNegative) {
            num = -num;
        }
        while (num > 0) {
            sb.append(num % 7);
            num /= 7;
        }
        String ret = sb.reverse().toString();
        return isNegative ? "-" + ret : ret;
    }

    //Java 中 static String toString(int num, int radix) 可以将一个整数转换为 radix 进制表示的字符串。
    public String convertToBase7II(int num) {
        return Integer.toString(num, 7);
    }
}
