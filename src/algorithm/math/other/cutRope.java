package algorithm.math.other;

/**
 * 长为n的绳子，剪成整数长的m段，每段绳子的长度记为k[1],...,k[m]，求得K[1]*...*k[m]的最大乘积
 */
public class cutRope {
    //剪绳子的动态规划算法
    public int solution(int target){
        //异常处理
        if(target < 0)
            throw new IllegalArgumentException("Illegal Paramters");
        if(target < 2)
            return 0;
        if(target == 2)
            return 1;
        if(target == 3)
            return 2;
        //创建数组存储子问题最优解
        int[] mul = new int[target+1];
        mul[0]=0;
        mul[1]=1;
        mul[2]=2;
        mul[3]=3;
        for(int i = 4; i <= target; i++){
            int max = 0;
            for(int j = 1; j <= i/2; j++){
                int temp = mul[j]*mul[i-j];
                if(max < temp)
                    max = temp;
            }
            mul[i] = max;
        }
        return mul[target];
    }
    //如果允许不剪操作，那么受影响的只是n=1，n=2，n=3
    public int cutRope2(int n){
        if(n < 0)
            throw new IllegalArgumentException("Illegal Paramters");
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        int[] mul = new int[n+1];
        mul[0]=0;
        mul[1]=1;
        for(int i = 2; i <= n; i++){
            int max = i;
            for(int j = 1; j <= i/2; j++){
                int temp = mul[j]*mul[i-j];
                if(max < temp)
                    max = temp;
            }
            mul[i] = max;
        }
        return mul[n];
    }
}
