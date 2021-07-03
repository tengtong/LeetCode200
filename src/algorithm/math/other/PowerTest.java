package algorithm.math.other;

/**
 * 求base^n
 * 这里用快速幂的形式，降低时间复杂度
 */
public class PowerTest {
    public double solution(double base, int n) {

        double res = 1;
        int cifang = 0;
        //先检查base、n
        if(n<0){//当次方<0时，base不能为0
            if(base == 0){
                throw new RuntimeException("分母不能为0");
            }
        }else if(n==0){
            return 1;
        }else{
            cifang = n;
        }

        //将指数用二进制形式求值
        while (cifang != 0){
            double temp = base;
            if((cifang&1)==1){
                res = res * temp;
            }
            temp = temp * temp;//一次if不成立，就代表n缩小了一半，即2^16=2^8*2^8，把现有的乘积做一次累乘
            cifang = cifang >> 1;
        }

        //这里还要对n<0的res情况，做一次处理，上面只是避免base==0，但是对base非0的情况没有做考虑
        res = n>=0?res:(1/res);
        return res;
    }
}
