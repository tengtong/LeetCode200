package algorithm.search.backtracking;

import sun.font.CStrike;

import java.util.*;

/**
 * 数字键盘组合
 * 题目：在数字键盘上输入数字键，然后输出对应所有可能的字母组合，输入为'2'-'9'
 * Input："23"
 * output：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 思路：建立一个枚举，或者一个固定数组来存储"对应关系"
 */
public class PhoneNumComb1 {
    private static final String[] KEYS = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};//0.1.2...9

    /**
     * 字符组合：输出所有可能的字符组合情况
     * @param digits 数字键
     * @return 字符数组
     */
    public List<String> letterCombinations(String digits) {
        //结果集（默认初始应该为0）
        List<String> combinations = new ArrayList<>();
        StringBuilder tempCombine = new StringBuilder();
        //考虑特殊情况
        if (digits == null || digits.length() == 0) {
            return combinations;
        }
        //实际操作
        doCombination(tempCombine, combinations, digits);
        return combinations;
    }

    /**
     * 组合（递归）
     * @param tempCombine 'ad'
     * @param combinations 结果集 ["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * @param digits 数字
     * ps：这里同一套递归可以两层实现，是因为组合中的每一位分布情况都一致，所以第一位全排列的同时，对第二位也进行全排列，就可以列举出所有可能
     */
    private void doCombination(StringBuilder tempCombine, List<String> combinations, final String digits) {
        if (tempCombine.length() == digits.length()) {
            combinations.add(tempCombine.toString());//"ad"
            return;
        }
        int curDigits = digits.charAt(tempCombine.length()) - '0';//当前数字//在一个数字"2"的位置，已经选中了'a'字符
        String letters = KEYS[curDigits];//取出当前数字对应的字符
        for (char c : letters.toCharArray()) {//遍历字符数组，逐个取字符
            tempCombine.append(c);//添加//a，ad，ae，af
            doCombination(tempCombine, combinations, digits);
            tempCombine.deleteCharAt(tempCombine.length() - 1);//删除//第二层递归删除ad->a//第一层递归删除a->null
        }
    }
}
