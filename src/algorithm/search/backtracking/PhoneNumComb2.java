package algorithm.search.backtracking;

import java.util.*;

/**
 * 求出数字键盘上字母的所有的组合情况
 */
public class PhoneNumComb2 {
    private static final String[] KEYS = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> solution(String dights){
        List<String> combinations = new ArrayList<>();//结果集
        StringBuilder tempCombine = new StringBuilder();
        if (dights == null || dights.length() == 0){
            return combinations;
        }
        doCombination(tempCombine,combinations,dights);
        return combinations;
    }
    private void doCombination(StringBuilder tempCombine, List<String> combinations,final String dights){
        if (tempCombine.length() == dights.length()){
            combinations.add(tempCombine.toString());
            return;
        }
        int curDights = dights.charAt(tempCombine.length()) - '0';
        String letters = KEYS[curDights];
        for (char c:letters.toCharArray()){
            tempCombine.append(c);                         //添加
            doCombination(tempCombine,combinations,dights);
            tempCombine.deleteCharAt(tempCombine.length() - 1); //删除
        }
    }
}
