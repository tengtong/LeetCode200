package dataStructure.string;

import java.util.*;

/**
 * 有效字符串符号，{[()]}
 * 栈中记录的是该位置应该出现的右括号
 */
public class IsValidTest {
    public static boolean solution(String s){
        Stack<Character> stack = new Stack();
        for(char c:s.toCharArray()){
            if(c=='['){
                stack.push(']');
            } else if(c=='{'){
                stack.push('}');
            } else if(c=='('){
                stack.push(')');
            } else if(stack.isEmpty()||stack.pop()!=c){//如果输入元素不属于({[，那么就没有元素入栈栈为空，即栈为空表示输入的字符不合理
                return false;                          //或者当前遍历的元素与不是栈中记录的应该出现的右括号，则括号不匹配，字符串无效
            }
        }
        return stack.isEmpty();//如果全部都匹配的话，那么栈中的元素都会pop出去
    }
}
