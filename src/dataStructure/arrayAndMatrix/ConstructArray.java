package dataStructure.arrayAndMatrix;

/**
 * 数组相邻差值的个数
 * 数组元素为1～n的整数，要求构建数组，使得相邻的元素差值不相同的个数为k，如果有多种答案，只要实现并返回其中一种即可
 * 让前k+1个元素构建出k个不相同的差值，序列为：1,k+1,2,k,3,k-1,...,k/2,k/2+1
 * intput: n = 3, k = 2
 * output: [1,3,2]
 */
public class ConstructArray {

    //只需要按这个序列分布即可：1,k+1,2,k,3,k-1,...,k/2,k/2+1
    public int[] constructArray(int n, int k) {
        int[] ret = new int[n];
        ret[0] = 1;
        //i [1, k]，这里按照原有的序列，交替执行，直到插入了k/2个元素(interval的位置)，一共就形成了k个相邻元素差值不相同的元素
        for (int i = 1, interval = k; i <= k; i++, interval--) {
            ret[i] = i % 2 == 1 ? ret[i - 1] + interval : ret[i - 1] - interval;
        }
        //i [k+1, n]，剩余的位置就保证相邻差值都为1即可
        for (int i = k + 1; i < n; i++) {
            ret[i] = i + 1;
        }
        return ret;
    }
}
