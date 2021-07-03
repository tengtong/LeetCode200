package dataStructure.listNode.huawei;

import java.util.*;
//投机取巧的方法，利用Set集合存放的元素不重复来实现
public class Solution2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] res = s.split("");
        LinkedHashSet<Integer> list = new LinkedHashSet<>();
        for(String re:res){
            list.add(Integer.parseInt(re));
        }
        for(int i:list){
            for(int j=0;j<3;j++){
                System.out.print(i);
            }
        }
    }
}
