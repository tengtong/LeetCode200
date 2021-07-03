package algorithm.search.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 分割字符串使得每个部分都是回文数
 * intput: s = "aab",
 * output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> partitions = new ArrayList<>();
        List<String> tempPartition = new ArrayList<>();
        doPartition(tempPartition, partitions, s);
        return partitions;
    }

    private void doPartition(List<String> tempPartition, List<List<String>> partitions, String s) {
        if (s.length() == 0) {
            partitions.add(new ArrayList<>(tempPartition));
            return;
        }
        for (int i = 0; i < s.length() ; i++) {
            if (isPalindrome(s, 0 , i)) {
                tempPartition.add(s.substring(0, i + 1));
                doPartition(tempPartition, partitions, s.substring(i + 1));
                tempPartition.remove(tempPartition.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int begin, int end) {
        while (begin < end) {
            if (s.charAt(begin++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
