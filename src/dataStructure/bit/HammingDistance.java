package dataStructure.bit;

/**
 * 统计两个数的二进制表示有多少位不
 * Input: x = 1, y = 4
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * The above arrows point to positions where the corresponding bits are different.
 */
//TODO
public class HammingDistance {
    //对两个数进行异或操作，位级表示不同的那一位为 1，统计有多少个 1 即可
    public int hammingDistance1(int x, int y) {
        int z = x ^ y;
        int cnt = 0;
        while(z != 0) {
            if ((z & 1) == 1) cnt++;
            z = z >> 1;
        }
        return cnt;
    }

    //使用 z&(z-1) 去除 z 位级表示最低的那一位。
    public int hammingDistance2(int x, int y) {
        int z = x ^ y;
        int cnt = 0;
        while (z != 0) {
            z &= (z - 1);
            cnt++;
        }
        return cnt;
    }

    //可以使用 Integer.bitcount() 来统计 1 个的个数。
    public int hammingDistance3(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
