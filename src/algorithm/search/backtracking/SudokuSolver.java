package algorithm.search.backtracking;

/**
 * 数独（hard）
 * 数字1-9在每行只能出现一次
 * 数字1-9在每列只能出现一次
 * 数字1-9在每一个以粗实现分隔的 3x3 宫内只能出现一次
 * 空白格用'.'表示
 */
public class SudokuSolver {
    public boolean[][] rowsUsed = new boolean[9][10];
    public boolean[][] colsUsed = new boolean[9][10];
    public boolean[][] cubesUsed = new boolean[9][10];
    private char[][] board;

    public void solveSudoku(char[][] board) {
        this.board = board;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {//空白格
                    continue;
                }
                int num = board[i][j] - '0';//board中存的是字符
                rowsUsed[i][num] = true;
                colsUsed[i][num] = true;
                cubesUsed[cubeNum(i, j)][num] = true;
            }
            backtracking(0, 0);
        }
    }

    private boolean backtracking(int row, int col) {
        while (row < 9 && board[row][col] != '.') {
            row = col == 8 ? row + 1 : row;
            col = col == 8 ? 0 : col + 1;
        }
        if (row == 9) {
            return true;
        }
        for (int num = 1; num <= 9; num++) {
            if (rowsUsed[row][num] || colsUsed[col][num] || cubesUsed[cubeNum(row, col)][num]) {
                continue;
            }
            rowsUsed[row][num] = colsUsed[col][num] = cubesUsed[cubeNum(row, col)][num] = true;
            board[row][col] = (char) (num + '0');
            if (backtracking(row, col)) {
                return true;
            }
            board[row][col] = '.';
            rowsUsed[row][num] = colsUsed[col][num] = cubesUsed[cubeNum(row, col)][num] = false;
        }
        return false;
    }

    private int cubeNum(int i, int j) {
        int r = i / 3;
        int c = j / 3;
        return r * 3 + c;
    }
}
