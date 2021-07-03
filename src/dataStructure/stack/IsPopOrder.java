package dataStructure.stack;

import java.util.*;
/**
 * 输入栈的压入序列int[] a，判断int[] b是否是该栈的弹出序列
 * 把压入序列压入到栈中，用栈去模拟弹出序列是否可行
 * */
public class IsPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length == 0 || popA.length == 0)
            return false;
        Stack<Integer> s = new Stack<Integer>();
        int popIndex = 0;//因为压入和弹出的节奏不一致，所以用专门一个index来记录弹出顺序
        for(int i = 0; i< pushA.length; i++){
            s.push(pushA[i]);//把压入序列都压入栈，通过弹出序列模拟弹出过程，判断是否可行
            while(!s.empty() && s.peek()==popA[popIndex]){//如果栈不为空，且栈顶元素等于弹出序列时，pop
                s.pop();//出栈
                popIndex++;//弹出序列向后一位
            }
        }
        return s.empty();//如果遍历完压入序列之后，全部压完的同时，也全部弹出了，只剩下一个空栈，即该弹出序列的顺序可行
    }
}
