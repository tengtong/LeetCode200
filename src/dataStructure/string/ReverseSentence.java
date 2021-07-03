package dataStructure.string;

/**
 * 字符串中单词的翻转
 * Input: s="I am s student"
 * Output: "student a am I"
 * 思路：翻转字符串数组，和翻转字符串的思路相同
 */
public class ReverseSentence {
    public static String solution(String string){
        String[] strings = string.split(" ");
        for (int i=0;i<strings.length/2;i++){
            String temp = strings[i];
            strings[i] = strings[strings.length-1-i];
            strings[strings.length-1-i] = temp;
        }
        return string;
    }

    public static void main(String[] args) {
        String string = "I am s student";
        System.out.println(solution(string));
    }
}
