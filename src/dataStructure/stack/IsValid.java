package dataStructure.stack;

import java.util.*;

/**
 * 用栈实现括号匹配
 * "()[]{}"
 * Output : true
 * 思路：
 */
public class IsValid {

    //方法一
    public boolean isValid1 (String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '[') stack.push(']');
            else if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
//            这里为什么不这样写
//            这样逻辑是顺的好理解，但是代码简洁性差了点
//            就是匹配的情况只有一种，不匹配的情况有很多种，针对不匹配的情况写可以提高代码的冗余性
//            else if (stack.isEmpty() || c == stack.pop()) {
//                continue;
//            }
//            return true;
            else if (stack.isEmpty() || c != stack.pop()) return false;
        }
        return stack.isEmpty();
    }

    //方法二
    public boolean isValid2 (String s) {
        Stack<Character> stack = new Stack<>();
        //将输入字符串变成字符数组一一遍历
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                //在进入else时，若栈中没有左半边括号待匹配，则表示先出现了右括号，则匹配失败
                if (stack.isEmpty()) {
                    return false;
                }
                char cStack = stack.pop();
                boolean b1 = c == ')' && cStack != '(';
                boolean b2 = c == ']' && cStack != '[';
                boolean b3 = c == '}' && cStack != '{';
                //if为条件判断语句，只有b1、b2、b3有一个正确就会进入if语句，最终就是显示匹配失败
                if (b1 || b2 || b3) {
                    return false;
                }
            }
        }
        //如果全部元素都遍历完，且括号都一一碰撞匹配完后，则栈中内容为空，显示匹配成功
        return stack.isEmpty();
    }

    //哈希表法
    public boolean isValid3(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

}
