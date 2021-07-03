package dataStructure.stack;

import java.util.*;
/**
 * 已知栈的压入序列，判断当前弹出序列是否合理
 */
public class IsPopOrderTest {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        //先判断特殊情况，要保证一些特殊的测试用例情况
        if(pushA==null || popA==null){//即没有弹入和弹出序列
            return false;
        }
        //开始操作遍历pushA存入stack
        Stack<Integer> stack = new Stack();
        int popIndex = 0;
        for(int i=0;i<pushA.length;i++){//遍历pushA
            stack.push(pushA[i]);//基本的压入操作
            while(!stack.empty()&&stack.peek()==popA[popIndex]){//持续遍历判断，直到栈为空或者栈顶元素不是pop序列//当栈不是空的时候，且当前元素是推出序列时
                popIndex++;
                stack.pop();
            }
        }
        return stack.empty();
    }
}
