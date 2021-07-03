package algorithm.sort;

import java.util.*;

/**
 * 寻找出现频率最多的k个元素
 * Input：nums=[1,1,1,2,2,3] and k =2
 * Output: [1,2]
 * 思路：HashMap+桶排（每个桶存储一个范围区间的元素，并在桶内进行排序）
 *      只要和频率/次数相关，一般都需要用hashmap来统计次数
 */
public class TopKthFreNum {
    public List<Integer> solution(int[] nums,int k){
        //1、hashMap统计每个元素的个数
        Map<Integer,Integer> frequencyMap = new HashMap<>();
        for(int num:nums){
            frequencyMap.put(num,frequencyMap.getOrDefault(num,0)+1);
        }
        //2、用List数组来存放每个频率的出现的元素
        List<Integer>[] buckets = new ArrayList[nums.length + 1];//数组中存的单元是List<Integer>单元
        for(int key:frequencyMap.keySet()){
            int frequency = frequencyMap.get(key);
            if (buckets[frequency] == null){
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        //3、遍历桶，buckets[frequency]，故倒序取桶，就可以取出出现频率最多的k个元素
        List<Integer> topk = new ArrayList<>();//topk==[1,2]，存放结果集
        for (int i=buckets.length-1;i>=0 && topk.size()<k;i--){
            if (buckets[i] == null){//如果该次数没有对应的元素，则跳过本次循环
                continue;
            }
            int temp = k-topk.size();//k是需要统计的个数，topk.size()是当前数组已经记录的个数
            if (buckets[i].size() <= temp){//当
                topk.addAll(buckets[i]);//添加当前频率的元素
            } else if (buckets[i].size() > temp){
                topk.addAll(buckets[i].subList(0,temp));
            }
        }
        return topk;
    }
}
