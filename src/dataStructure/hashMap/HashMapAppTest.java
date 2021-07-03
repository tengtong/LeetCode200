package dataStructure.hashMap;

import java.util.*;

/**
 * 统计字符串中字符的出现的次数
 */
public class HashMapAppTest {
    public void CharacterCounnt(String str){
        char[] chars = str.toCharArray();
        Map<Character,Integer> map = new HashMap();
        //往map添加字符，key=c,value=count
        for(char c:chars){
            if(map.containsKey(c)){//如果已经有这个key
                Integer value = map.get(c);//从map取出value，并进行+1
                value++;
                map.put(c,value);
            }else {
                map.put(c,1);
            }
        }
        //添加完之后统计value值
        //entry取获取一组 <key,value>
        for(Map.Entry entry:map.entrySet()){
            Character key = (Character)entry.getKey();//entry.getKey()默认返回是object类型
            Integer value = (Integer)entry.getValue();
            System.out.print(key);
            System.out.println(value);
        }
    }
}
