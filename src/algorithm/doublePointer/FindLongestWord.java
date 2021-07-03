package algorithm.doublePointer;

import java.util.*;

/**
 * 题目：删除s中的一些字符，使得它构成字符串列表d中的一个字符串，找出能构成的最长字符串。（如果有多个相同长度的结果，返回字典序的最小字符串）
 * 思路：遍历d中的子串，分别判断在s中是否也是其子串
 */
public class FindLongestWord {
    public String solution(String s,List<String> d){
        String longestWord = "";//记录最长字符子串
        for(String target:d){//遍历数组d，判断其中的元素是否能通过串s删除得到
            int len1 = longestWord.length();
            int len2 = target.length();
            //跳过本地循环//如果"最长字符子串"长度大大于当前元素长度 || 或者长度一样时，比较两个的字典序，如果"最长字符子串"的字典序大
            if(len1>len2 || (len1==len2 && longestWord.compareTo(target)<0)){
                continue;
            }
            //如果不满足上述条件，且当前"字符子串"是s的子串时，则可以更新"最长字符子串"
            if(isSubstr(s,target)){
                longestWord = target;
            }
        }
        return longestWord;
    }

    /**
     * 方法：双指针遍历法同时遍历两个数组，如果相同次数和target长度一致，则表示target是s的子串
     * @param s
     * @param target
     * @return
     */
    private boolean isSubstr(String s,String target){
        int i=0,j=0;
        while(i<s.length()&&j<target.length()){
            if(s.charAt(i) == target.charAt(j)){
                j++;
            }
            i++;
        }
        return j==target.length();
    }
}
