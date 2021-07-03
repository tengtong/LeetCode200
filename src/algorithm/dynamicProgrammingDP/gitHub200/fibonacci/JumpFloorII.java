package algorithm.dynamicProgrammingDP.gitHub200.fibonacci;

/**
 * 变态跳台阶问题，每次可以跳1级，2级 ... n级，求到n阶台阶有几种方法
 * 方法一：找规律，数学归纳法。先列出几个数之后，再开始找规律
 *       f(0) = 0
 *       f(1) = 1
 *       f(2) = 2
 *       f(3) = 1-f(2) + 2-f(1) + 3-f(0)
 *       f(4) = 1-f(3) + 2-f(2) + 3-f(1) + 4-f(0)
 *       ...
 *       f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(1) + f(0)
 *            = 2 * f(n-1)
 */
public class JumpFloorII {
    //方法一：找规律，f(n) = 2 * f(n-1)
    public int solution(int targer){
        if(targer<=0){
            return -1;
        }
        if(targer==1){//截止条件，这里到f(1)就会触底返回了，所以不需要把f(0)列入正常的计算序列
            return 1;
        }
        return 2 * solution(targer-1);
    }
    public static void main(String[] args) {
        JumpFloorII jumpFloorII = new JumpFloorII();
        int res = jumpFloorII.solution(5);
        System.out.println(res);
    }
}
