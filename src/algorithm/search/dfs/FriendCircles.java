package algorithm.search.dfs;

/**
 * 好友关系的连通分量数目
 *
 * Input:
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]]
 * output: 2
 *
 * 思路：好友关系可以看成是一个无向图，假如第0个人与第1个人是好友，那么M[0][1]和M[1][0]的值都是1
 */
public class FriendCircles {
    private int n;

    public int findCircleNum(int[][] M) {
        n = M.length;
        int circleNum = 0;//结果集
        boolean[] hasVisited = new boolean[n];//标记
        for (int i = 0; i < n; i++) {
            if (!hasVisited[i]) {//如果该点没有被标记过，hasVisited[i]=false，进入循环
                dfs(M, i ,hasVisited);
                circleNum++;
            }
        }
        return circleNum;
    }

    private void dfs(int[][] M, int i, boolean[] hasVisited) {
        hasVisited[i] = true;//标记
        for (int k = 0; k < n; k++) {
            if (M[i][k] == 1 && !hasVisited[k]) {
                dfs(M, k, hasVisited);
            }
        }
    }
}
