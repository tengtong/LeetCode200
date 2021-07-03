package dataStructure.hashMap;

import java.util.*;
public class HashMapApplication {
    /**
     * 统计String中char出现的次数
     * @param s
     */
    public static void CharacterCount(String s) {
        HashMap<Character,Integer> map = new HashMap<>();//把char当作key存入，value是存现的次数
        for(char c:s.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
        }
        for(Map.Entry<Character, Integer> entry:map.entrySet()) {//可以把hashmap中所有的key-value取出来，并且以entry的形式一起保存
            System.out.println(entry.getKey()+"-->"+entry.getValue());//然后可以使用getKey()和getValue的方法
        }
    }
}
