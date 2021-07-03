package algorithm.huaDongChuangKou;

import java.util.ArrayList;

/**
 * 求和为s和所有连续数列
 * 滑动窗口
 * 输入：sum
 * 输出：所有可能数列
 */
public class FindContinuousSequenceTest {
    public ArrayList<ArrayList<Integer>> solution(int sum) {
        int plow = 0;
        int phigh = 1;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        while(phigh>plow){//这里使用>而不是>=可以保证序列至少有两个数
            int temp = (phigh+plow)*(phigh-plow+1)/2;
            if(temp == sum){
                ArrayList list = new ArrayList();
                for(int i=plow;i<=phigh;i++){
                    list.add(i);
                }
                res.add(list);
                plow++;
            } else if(temp < sum){
                phigh++;
            } else if (temp > sum){//如果temp已经大sum，plow会一直++，最后也可以停止循环
                plow++;
            }
        }
        return res;
    }
}
