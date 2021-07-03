package algorithm.search.dfs;

/**
 * 矩阵中的连通分量数目
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成
 * Input：
 * 11000
 * 11000
 * 00100
 * 00011
 * output：3
 * 思路：可以将矩阵看成一张有向图
 */
public class NumIslands {
    private int m, n;
    private int[][] drection = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        //计算特殊情况
        if (grid == null || grid.length == 0) {
            return 0;
        }
        m = grid.length;//行
        n = grid[0].length;//列
        int islandsNum = 0;//岛屿数量
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n ;j++) {
                if (grid[i][j] != '0') {//当找到某点的值为1，即是陆地，即对该点展开可达性搜索
                    dfs(grid, i, j);//对一块陆地附近的陆地都进行可达性遍历，找遍所有相连通的陆地，并将其标记为"水"后，表示一块陆地确定完毕
                    islandsNum++;//找遍一块陆地连通的所有路径之后，确定岛屿数量+1
                }
            }
        }
        return islandsNum;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {//当该点不在矩阵范围内，或者该点是"水"则对该点进行dfs
            return;
        }
        grid[i][j] = '0';//标记，将已经遍历过的陆地标记为水，避免在其他地方二次访问
        for (int[] d: drection) {
            dfs(grid, i + d[0], j + d[1]);//得到一个新节点时，立即对新节点进行遍历
        }
    }
}
