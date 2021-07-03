package dataStructure.bit;

/**
 * 判断一个数是不是 4 的 n 次方
 */
//TODO
public class IsPowerOfFour {
    //这种数在二进制表示中有且只有一个奇数位为 1，例如 16（10000）。
    public boolean isPowerOfFour1(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0b01010101010101010101010101010101) != 0;
    }
    //也可以使用正则表达式进行匹配。
    public boolean isPowerOfFour2(int num) {
        return Integer.toString(num, 4).matches("10*");
    }
}
