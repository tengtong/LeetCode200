package dataStructure.string;

import java.util.*;

/**
 * 寻找字符流中第一个只出现一次的元素
 * 例如："google"时，第一个只出现一次的字符是"l"
 * 如果要判断是否只出现一次，需要遍历完整个字符串，故可以用hashMap统计
 */
public class FirstE {
    HashMap<Character, Integer> map=new HashMap();//key:Character，value:Integer//map主要统计每个字符的个数
    ArrayList<Character> list=new ArrayList<Character>();
    //Insert one char from stringstream
    //map负责统计次数，通过hash的形式统计，key是字符，value是次数
    public void Insert(char ch) {
        if(map.containsKey(ch)){
            map.put(ch,map.get(ch)+1);//如果该字符已经有存入的了，那么value+1
        }else{
            map.put(ch,1);
        }
        list.add(ch);//再把每个char存入ArrayList<Character>
    }
    //再遍历字符集合，找出value是1的字符
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        char c='#';
        for(char key : list){
            if(map.get(key)==1){
                c=key;
                break;
            }
        }
        return c;
    }
}
