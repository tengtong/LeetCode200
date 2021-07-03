package algorithm.math.other;

/**
 * 斐波那契蛇
 *
 */
public class FibonacciSnake {
    //生成n个斐波那契数列，不是第n个，然后将数列存入数组中
    public static int[] fibonacci(int n){
        int [] fibonacciList = new int[n];
        if (n == 1){
            fibonacciList[0] = 1;
        }else if (n == 2){
            fibonacciList[0] = 1;
            fibonacciList[1] = 1;
        }else {
            fibonacciList[0] = 1;
            fibonacciList[1] = 1;
            for (int i = 2;i<n;i++){
                fibonacciList[i] = fibonacciList[i-1]+fibonacciList[i-2];
            }
        }
        return fibonacciList;
    }
    //打印结果
    public static void print(int n){//打印n行，就是n*n个斐波那契
        int[] fibonacciList = fibonacci(n*n);
        int[][] matrix = new int[n][n];
        fillInt(matrix,fibonacciList,n*n-1,0);//然后把这个斐波那契序列填充到矩阵中
        for (int i = 0;i < matrix.length;i++){
            for (int j=0;j<matrix.length;j++){
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
    }
    //将数列填充进数组
    public static void fillInt(int[][] matrix,int[] fibonacciList,int index,int n){
        int step = matrix.length-2*n;//步长
        if (step < 1){
            return;
        }
        //1
        for (int j=n;j<matrix.length - n;j++){
            matrix[n][j] = fibonacciList[index];
            index--;
        }
        //2
        for (int i=n+1;i<matrix.length - n;i++){
            matrix[i][matrix.length - n - 1] = fibonacciList[index];
            index--;
        }
        //3
        for (int j = matrix.length - n - 2;j>=n;j--){
            matrix[matrix.length - n - 1][j] = fibonacciList[index];
            index--;
        }
        //4
        for (int i=matrix.length - n - 2;i>n;i--){
            matrix[i][n] = fibonacciList[index];
            index--;
        }
        n++;
        fillInt(matrix,fibonacciList,index,n);
    }

    public static void main(String[] args) {
        print(3);
    }
}

