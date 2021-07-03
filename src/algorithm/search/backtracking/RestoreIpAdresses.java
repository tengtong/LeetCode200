package algorithm.search.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * IP地址划分
 * 题目：从字符串中返回所有有效IP地址
 * Input: "25525511135"
 * output： ["255.255.11.135"，"255.255.111.35"]
 * 思路：回溯，将所有可能排列出来
 */
public class RestoreIpAdresses {

    public List<String> restoreIpAdresses(String s) {
        List<String> adresses = new ArrayList<>();
        StringBuilder tempAdress = new StringBuilder();
        doRestore(0, tempAdress, adresses, s);//StringBulider可以对String完成一些其他操作
        return adresses;
    }

    /**
     * 回溯
     * @param k 辅助变量，ip地址共4段组成部分
     * @param tempAdress 临时集，其中一个结果的部分//255.255//10.23.101
     * @param adresses 结果集
     * @param s
     */
    private void doRestore(int k, StringBuilder tempAdress, List<String> adresses, String s) {
        //递归判断
        if (k == 4 || s.length() == 0) {
            if (k == 4 && s.length() == 0) {//符合标准，已经分配了4段，且字符已经分配完
                adresses.add(tempAdress.toString());
            }//如果已经分成了4个部分，或者s已经分配完毕，但是并没有同时满足，即不符合标准，则不作处理
            return;//递归返回
        }
        //遍历字符串
        for (int i = 0; i < s.length() && i <= 2; i++) {//i<=2，从s中每次取三个
            if (i != 0 && s.charAt(0) == '0') {//不符合条件//当遍历的不是第一个字符，而s中第一个字符是'0'
                break;
            }
            //每一遍for循环，都会对尾部进行一次搜索，即//10.11.20//101.1.20
            //正常情况，从s中取[0,i]
            String part = s.substring(0, i + 1);
            if (Integer.valueOf(part) <= 255) {
                //将part部分拼接到tempAdress
                if (tempAdress.length() != 0) {//如果有前一部分，则进行组装
                    part = "." + part;
                }
                tempAdress.append(part);
                doRestore(k + 1, tempAdress, adresses, s.substring(i + 1));//substring(i+1)==substring(i+1, s.length + 1)
                                                         //s.substring时，方法的返回值是截取过的字符，但是s本身不会发生改变
                tempAdress.delete(tempAdress.length() - part.length(), tempAdress.length());//tempAdress.delete(start, end)
            }
        }
    }
}
