package dataStructure.arrayAndMatrix;

/**
 * 小朋友玩游戏，圈内剩下的最后一个元素
 * 圆环—数组，这里题实质并不难，只要用代码把逻辑实现就可以了
 */
public class LastRemainingTest {
    public int solution(int n,int m){//n是小朋友的个数，m是报号数
        if(n<1||m<1){
            return -1;
        }
        int step=0;//记做当前的报号数，因为一旦有小朋友出圈了，会接着报号，但是这里与小朋友的编号不再一致，故需要一个变量来记录
        int count=n;//记做圈内小朋的个数
        int[] zhuangtai = new int[n];//用来记录小朋友的状态//int[]数组，默认值是0//boolean默认值是false
        int lastpeople = 0;
        for(int i=0;i<n;i++){//用for循环思路清晰点，是一个for循环是一个小朋友的操作
            if(count==1){
                lastpeople = i;
                break;
            }
            if(zhuangtai[i]==-1){//该小朋友已经出圈，不再讨论
                continue;
            }
            step++;//开始报号
            if(step==m) {//报到了第m个//这里第一个小朋友报完号，step==1，故使step==m来判断
                zhuangtai[i]=-1;//小朋友出圈
                count--;//圈内小朋友数量-1
                step=0;//重新报号
            }
            if(i==n-1){ i=0; }//如果当前是第n-1个小朋友，下一棒交给第0个小朋友，以此保证循环能继续
        }
        return lastpeople;
    }
}
