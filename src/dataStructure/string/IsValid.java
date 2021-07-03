package dataStructure.string;

import java.util.Scanner;
import java.util.Stack;

/**
 * 字符串匹配
 * 给定一个只包括'(',')','[',']','{','}'的字符串，判断字符串是否有效
 * 匹配括号，例如：{[()]}肯定都是先有的左括号，且是先检测到的最后匹配因为要在最外围，故用栈很合适
 */
public class IsValid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        boolean res = IsValid.solution2(s);
        System.out.println(res);
    }
    public static boolean solution1(String s){//80%
        if(s.length()<2||s.length()%2!=0){
            if(s.isEmpty()){
                return true;
            }else {
                return false;
            }
        }
        int count = 0;
        int length = s.length();
        while (count<length/2){
            s = s.replace("{}","").replace("[]","").replace("()","");
            count++;
        }
        if(s.length()>0){
            return false;
        }else {
            return true;
        }
    }
    public static boolean solution2(String s){//80%//时间更短
        Stack<Character> stack = new Stack<>();
        for (char c:s.toCharArray()){
            if (c == '(') {//如果我先检测到了一个(，那么自动往栈中压入)，表示该位置应该有一个)，如果遍历到后面位置元素时，该元素也确实与stack.pop的元素相同，则说明该位置出现的)合理，与栈一致
                stack.push(')');
            }else if(c=='['){
                stack.push(']');
            }else if(c=='{'){
                stack.push('}');
            }else if(stack.isEmpty()||stack.pop()!=c){//如果元素c不属于([{的一种，那就是}])开头或者包含了其他字母符号，那么该字符串就一个无效的字符串
                return false;
            }
        }
        return stack.isEmpty();
    }
}
