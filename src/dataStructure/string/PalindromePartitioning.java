package dataStructure.string;
import java.util.*;

/**
 * 分割字符串，使得返回的子串都是回文串，最后返回所有分割方案
 */
//方法一：暴力法，1个字母，2个字母，3个字母...直到满字母，全部都判断一遍
//方法二：在处理的时候去优先寻找更短的回文串，然后回溯找稍微长一些的回文串分割方法，不断回溯，分割，直到找到所有的分割方法
public class PalindromePartitioning {
    List<List<String>> res = new ArrayList<>();//结果集res

    /**
     * 分割
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0)
            return res;
        dfs(s, new ArrayList<String>(), 0);//从左到右遍历，left是当前遍历的index，即left左侧都已经找完了
        return res;
    }

    private void dfs(String s, List<String> remain, int left){//深度遍历
        if(left == s.length()){//判断终止条件
            res.add(new ArrayList<String>(remain));//添加remain到结果集中
            return;
        }
        //从长回文串开始判断，短的回文串一定包含在长的回文串里面
        for(int right=left;right<s.length();right++){//从left开始，依次判断left->right是不是回文串
            if(isPalindroom(s,left,right)){//判断是否是回文串
                remain.add(s.substring(left, right + 1));//添加到当前长回文串到list中
                dfs(s,remain,right+1);//从right+1开始继续递归，寻找回文串
                remain.remove(remain.size()-1);//回溯，从而寻找更长的回文串
            }
        }
    }
    /**
     * 判断是否是回文串
     */
    private boolean isPalindroom(String s,int left,int right){
        while(left<right&&s.charAt(left)==s.charAt(right)){
            left++;
            right--;
        }
        return left>=right;
    }

    public static void main(String[] args){
        PalindromePartitioning pp = new PalindromePartitioning();
        List<List<String>> list = pp.partition("abbca");
        for(List l:list){
            for(Object o:l){
                System.out.print(o+",");
            }
            System.out.println();
        }
    }
}
