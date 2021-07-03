package algorithm.search.backtracking;

import com.sun.deploy.panel.ExceptionListDialog;

/**
 * 在矩阵中匹配字符串
 * 单词必须要按照字母顺序，通过相邻的单元格内的字母构成（字符串不一定要求是正确的英文单词）
 * 其中"相邻"单元格是那些水平相邻或者垂直相邻的单元格，同一个单元格内的字母不允许被重复使用
 * Input：[
 *          ['A','B','C','E'],
 *          ['S','F','C','S'],
 *          ['A','D','E','E']
 *        ]
 * word = "ABCCED" -> return true;
 * word = "SEE" -> retrun true;
 * word = "ABCB" -> return false;
 *
 * ps：本题比较特殊，只需要判断一个word是否存在即可，用普通的dfs即可
 */
public class WordSearch {
    private final static int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};//十字型
    private int row;//行
    private int col;//列//column

    /**
     *
     * @param board 二维矩阵
     * @param word 单词
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {//空word，也算匹配
            return true;
        }
        if (board == null || board.length == 0 || board[0].length == 0) {//空矩阵，匹配失败
            return false;
        }

        row = board.length;
        col = board[0].length;
        boolean[][] hasVisited = new boolean[row][col];//元素标记//tempSet

        for (int r = 0; r < row ; r++) {
            for (int c = 0; c <= col ; c++) {
                if (backtracking(0, r, c, hasVisited, board, word));{
                    return true;
                }
            }
        }

        //如果遍历了所有情况还没有，则失败
        return false;
    }

    //dfs
    private boolean backtracking(int tempLen, int r, int c, boolean[][] visited, final char[][] board, final String word) {
        if (tempLen == word.length()) {
            return true;
        }
        if (r < 0 || r >= row || c < 0 || c >= col
            || board[r][c] != word.charAt(tempLen) || visited[r][c]) {
            return false;
        }

        visited[r][c] = true;

        for (int[] d : direction) {
            if (backtracking(tempLen + 1, r + d[0], c+ d[1], visited, board, word)) {
                return true;
            }
        }

        visited[r][c] = false;

        return false;
    }
}
