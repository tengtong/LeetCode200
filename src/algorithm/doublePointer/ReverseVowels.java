package algorithm.doublePointer;

import java.util.*;
/**
 * 反转字符串中的元音字符
 * abd->bda
 * 使用双指针，一个指针从头向尾遍历，一个指针从尾到头遍历，当两个指针都遍历到元音字符时，交换这两个元音字符
 */
public class ReverseVowels {

    //集合初始化
    //Arrays.asList初始化//asList 是 Arrays 的静态方法，这里使用了静态导入，这种方式添加的是不可变的 List, 即不能添加、删除等操作
    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    //匿名内部类形式初始化
    private final static HashSet<Character> test = new HashSet<Character>(){{
        add('a');add('e');add('i');add('u');
        add('A');add('E');add('I');add('U');
    }};

    public String reverseVowels(String s) {
        if (s == null) return null;
        int i = 0, j = s.length() - 1;
        char[] result = new char[s.length()];
        while (i <= j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!vowels.contains(ci)) {//如果ci不是原音字母，ci存入结果集，i++，s.chartAt(i)取下一个ci
                result[i++] = ci;
            } else if (!vowels.contains(cj)) {//如果ci是原音字母，cj不是原音字母，cj存入结果集，j--，s.chartAt(j)取下一个cj
                result[j--] = cj;
            } else {//如果此时的ci和cj都是原音字母，交换了两个字符，i++，j--，遍历下一个元素
                result[i++] = cj;
                result[j--] = ci;
            }
        }
        return new String(result);
    }

}