package dataStructure.arrayAndMatrix;

/**
 * 抽5张扑克，判断抽到的5张是否是顺子
 * 顺子==不出现重复的情况&&(max-min==4)
 * 同时，大小王可以重复
 */
public class IsContinuousTest {
    public boolean solution(int [] numbers) {
        if(numbers.length<5){
            return false;
        }
        int max = -1;//最小是0
        int min = 14;//最大是k为13
        //统计抽到的牌的最大值和最小值
        int[] count = new int[14];
        count[0]=-5;//大小王一共有5张，这里特殊设置一下使得大小王可以重复
        for(int i=0;i<numbers.length;i++){
            count[numbers[i]]++;
            //先判断是否存在重复的数
            //使用int nusms[14]的方式来记录
            if(count[i]>1){
                return false;
            }
            //这里要对大小王的情况做一个单独判读，大小王不参与max和min的统计
            if(numbers[i]==0){
                continue;
            }
            if(numbers[i]>max){
                max = numbers[i];
            }else if(numbers[i]<min){
                min = numbers[i];
            }
        }
        if(max-min<5){
            return true;
        }
        return false;
    }
}
