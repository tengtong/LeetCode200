package algorithm.divideAndConquer;

/**
 * 分治
 * 分而治之，可以参考分治排序的思想
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给表达式加括号
 * Input: "2-1-1"
 * Output : [0, 2]
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 */
public class DiffWaysToCompute {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ways = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '+':
                                ways.add(l + r);
                                break;
                            case '-':
                                ways.add(l - r);
                                break;
                            case '*':
                                ways.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if (ways.size() == 0) {
            ways.add(Integer.valueOf(input));
        }
        return ways;
    }
}
