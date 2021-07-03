package dataStructure.arrayAndMatrix;

import java.util.PriorityQueue;

/**
 * 有序矩阵的Kth Element
 * 你一个 nxn 矩阵matrix，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
 * 请注意，它是排序后的第k小元素，而不是第k个不同的元素。
 * intput：
 * matrix =
 * [        n
 *    [1, 3, 5],
 *  m [2, 4, 6],
 *    [3, 5, 7]
 * ],
 * k = 8,
 * output：13
 * 其中从分布上来看，只保证了每行和每列元素都是按升序排序，即只有当前元素的上下、左右有关系，其他位置都没有直接关系
 */
public class KthSmallest {

    //方法一：二维数组转成一维数组，然后进行排序，找出第k个

    //方法二：归并排序，对矩阵中的两个一维数组进行归并

    /**
     * 方法三：二分查找法
     * 矩阵内的元素从左上到右下是递增的，左上为最小，右下为最大，取个mid可以将矩阵分成左上和右下两块
     * 沿着分割线走一遍就能知道比mid小的有多少个，比mid大的有多少个
     * 以此不断的二分，就能从lo～hi中寻找到第k个小的元素
     * 在最小和最大之间通过个数实现二分查找，以此来找到第k小的元素
     */
    public int kthSmallest3(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        //初始位置看来，lo是矩阵最小的，hi是矩阵最大的
        //[        n
        //    [lo,  ,  ],
        //  m [  ,  ,  ],
        //    [  ,  ,hi]
        // ]
        int lo = matrix[0][0], hi = matrix[m - 1][n - 1];
        //while循环
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n && matrix[i][j] <= mid; j++) {
                    //只有符合当前遍历的元素，比lo和hi的中值低，才会进行统计
                    cnt++;
                }
            }
            if (cnt < k) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    /**
     * 方法四：堆解法
     */
    public int kthSmallest4(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        PriorityQueue<Tuple> priorityQueue = new PriorityQueue<Tuple>();
        for (int j = 0; j < n; j++) {
            priorityQueue.offer(new Tuple(0, j, matrix[0][j]));
        }
        //小根堆，去掉k-1个堆顶元素，此时堆顶元素就是第k的数
        for (int i = 0; i < k - 1; i++) {
            Tuple t = priorityQueue.poll();
            if (t.x == m - 1) {
                continue;
            }
            priorityQueue.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
        }
        return priorityQueue.poll().val;
    }
}

