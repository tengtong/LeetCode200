package dataStructure.string;

/**
 * 字符串同构
 * Input: "egg","add"
 * Output: true
 * ps: 它不管add还是abb，字符大小无关，只与结构相同
 * 思路：记录一个字符上次出现的位置，如果两个字符串中的字符上次出现的位置一样，那就属于同构了
 */
public class IsIsomorphic {
    public boolean isIsomorphic(String s,String t){
        //初始默认都是0//256是因为一共有256个ASCII码//这里也可以用int[26]，c-'a'
        int[] preIndexOfS = new int[256];
        int[] preIndexOfT = new int[256];
        //遍历s和t
        for (int i = 0; i < s.length(); i++){
            char sc = s.charAt(i);//除了用toCharArray，也可以用s.charAt(i)
            char tc = t.charAt(i);
            //如果遍历到ad"d"和eg"e"，d由于出现第二次了，preIndexOfS[sc]==2，e虽然出现第二次，但是preIndexOfT[tc]==1，也会不相等，只有两个字符串同构，才会相同//直接输入字符等于ACSII码，把当前字符当做Index
            if (preIndexOfS[sc] != preIndexOfT[tc]) {
                return false;
            }
            //这里累加用"i+1"，不是"++1"，故与元素的出现顺序有关//在256位中把当前字符作为Index加1
            preIndexOfS[sc] = i + 1;
            preIndexOfT[tc] = i + 1;
        }
        return true;
    }
}
