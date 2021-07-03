package dataStructure.arrayAndMatrix;

/**
 * 扑克牌顺子
 * 抽5张扑克，判断是是否是顺子
 * 且大小王为0，A为1,J为11,Q为12,K为13，大小王可以当作任意数
 * 顺子 ==（max-min==4）&& 没有重复的情况
 * 大小王的存在使得max-min可以<4
 */
public class IsContinuous {
    public boolean solution(int [] numbers) {//numbers，抽到的5张卡
        if(numbers.length<=4){
            return false;
        }
        int[] d = new int[14];//从0-13一共14个数，统计抽到牌的张数，主要是统计是否有抽到重复的卡
        d[0] = -5;
        int len = numbers.length;
        int max = -1;//保证抽到任意数都可以更新max
        int min = 14;//保证抽到任意数都可以更新min
        for(int i =0;i<len;i++){//遍历numbers，模拟抽卡的过程//
            d[numbers[i]]++;//对抽到的牌数量+1
            if(numbers[i] == 0){//抽到王了
                continue;//跳过此轮循环，不再进行下面的语句，即可以重复，且不参与max和min的统计
            }
            if(d[numbers[i]] > 1){//避免抽到重复的情况
                return false;
            }
            if(numbers[i] > max){//更新max
                max = numbers[i];
            } else if(numbers[i] < min){//更新min
                min = numbers[i];
            }
        }
        //已经满足没有重复的情况
        if(max - min < 5){//如果是顺子的话，最大值-最小值=4，如果抽到大小王，则大小王可以代替顺子的最大或者最小，差值会小于4
            return true;
        }//如果不满足，则不是顺子
        return false;
    }
}
