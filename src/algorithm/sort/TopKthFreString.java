package algorithm.sort;

import java.util.*;

/**
 * 按照字符出现次数对字符串排序
 * 思路：hashMap统计出现次数+桶排按频率存元素
 * 总结：出现次数==hashmap统计，对次数再做计算==用buckets按频率存元素。
 *      即hashMap(key=num，value=frequency)，buckets[frequency]=num，两次反转
 * Input: "tree"
 * Output: "eert" or "eetr"
 */
public class TopKthFreString {
    public static String solution(String str){
        //由hashMap统计出现次数，即key是元素，value是频率
        Map<Character,Integer> frequencyMap = new HashMap<>();
        for(char c:str.toCharArray()){//字符串转字符数组
            frequencyMap.put(c,frequencyMap.getOrDefault(c,0)+1);
        }
        //桶排按频率存元素，即数组中存的类型是List，buckets[frequency]='c'
        List<Character>[] frequencyBucket = new ArrayList[str.length()+1];
        for(char c:frequencyMap.keySet()){
            int fre = frequencyMap.get(c);
            if(frequencyBucket[fre] == null){
                frequencyBucket[fre] = new ArrayList<>();
            }
            frequencyBucket[fre].add(c);
        }
        StringBuilder s = new StringBuilder();
        for(int i=frequencyBucket.length-1;i>=0;i--){//倒序遍历每个桶，桶内存的是每个频率
            if(frequencyBucket[i] == null){
                continue;
            }
            for (char c:frequencyBucket[i]){//遍历桶内的每个元素
                for(int j = 0;j<i;j++){//i表示出现的频率，即往结果集添加i次
                    s.append(c);
                }
            }
        }
        return s.toString();
    }

    public static void main(String[] args) {
        String s = "tree";
        String result = TopKthFreString.solution(s);
        System.out.println(result);
    }
}
