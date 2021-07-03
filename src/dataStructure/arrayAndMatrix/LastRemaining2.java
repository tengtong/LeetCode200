package dataStructure.arrayAndMatrix;

/**
 * 小朋友玩游戏
 */
public class LastRemaining2 {
    public int solution(int n,int m){//n个小朋友，第m+1个报号(从0开始)
        int s=0;
        if(m == 0){
            return -1;
        }
        for(int i=2;i<=n;i++){
            s = (s+m) % i;
        }
        return s;
    }
}
