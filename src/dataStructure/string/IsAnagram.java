package dataStructure.string;

/**
 * 判断两个字符串包含的字符是否完全相同
 * Input: s="anagram", t="nagaram"
 * return: true
 * 思路：可以用两个hashMap来统计，然后比较，由于这里只有26个小写字符，故可以使用26个整型数组对字符串出现的字符进行统计
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t){
        int[] ctns = new int[26];
        for (char c: s.toCharArray()){
            ctns[c - 'a']++;
        }
        for (char c: t.toCharArray()){
            ctns[c - 'a']--;
        }
        for (int cnt:ctns){
            if (cnt != 0){//只要有一位字符次数相减后统计不为0
                return false;
            }
        }
        return true;
    }
}
