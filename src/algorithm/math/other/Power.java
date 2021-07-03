package algorithm.math.other;

/**
 * 重现函数power，快速幂
 * 传统方法是O(n)，这里是O(nlog)
 * 这里将指数化成二进制的形式来求，降低循环次数
 * 例如：10^1101 = 10^0001*10^0100*10^1000
 */
public class Power {
    public double solution(double base, int n) {
        double res = 1,curr = base;
        int exponent;
        //先对base和exponent的数学规则做一些检查
        if(n>0){            //次方>0
            exponent = n;
        }else if(n<0){      //次方<0时，要考虑base是否为0，其他情况base没有限制
            if(base==0)
                throw new RuntimeException("分母不能为0");
            exponent = -n;
        }else{              // n==0
            return 1;
        }
        //10^1101 = 10^0001*10^0100*10^1000 （^次方、异或）
        //这里通过右移的指数与"1"位于确定每个位上是否有1，然后通过底数翻倍的形式补偿大小//这里也是求二进制数中'1'的一种方法
        //   这里也可以还原出位与出来的位置"1"，乘以10的倍数获得补偿来，
        while(exponent!=0){
            if((exponent&1)==1) {     //取末尾的1，累乘
                res = res * curr;
            }
            curr = curr * curr;        //因为指数的右移，即缩小一倍，为保证累乘大小不变，底数翻倍
            exponent>>=1;             //指数右移一位，缩小一倍
        }
        return n>=0?res:(1/res);
    }
}
//java除法，取整，自动舍弃小数
