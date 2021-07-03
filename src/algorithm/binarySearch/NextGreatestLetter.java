package algorithm.binarySearch;

/**
 * 2. 大于给定元素的最小元素
 * 给定一个有序的字符数组letters和一个字符target，要求找出letters中大于target的最小字符，如果找不到就返回第1个字符
 * input:
 * letters = ["c", "f", "j"]
 * target = "d"
 * Output: "f"
 * Input:
 * letters = ["c", "f", "j"]
 * target = "k"
 * Output: "c"
 *
 * 思路：
 * 查找 —> 二分查找
 * O(n): 字符-ASCII，一遍for循环进行判断
 * O(logn): 二分
 * 这里与之前的不太一样，这里的查找的元素不一定在数组中，查找的对象不是具体某个元素，而是某个符合条件的元素
 * 即letters[mid]>target
 */
public class NextGreatestLetter {
    /**
     *
     * @param letters 有序字符数组
     * @param target 要寻找的目标字符
     * @return
     */
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int low = 0, hig = n - 1;
        //当low>hig的时候跳出区间，即区间两侧夹逼到具体某一个元素时，跳出循环
        while (low <= hig) {
            int mid = low + (hig - low) / 2;
            //目标在mid右侧，修改左区间，这里因为letters[mid]==target也不符合条件，还要继续寻找，所以letters[mid]<=target
            //普通的二分查找，目标条件都是letters[mid]==target，故还有小于和大于的情况需要分开讨论
            //   而这里的目标条件为letters[mid]>target，故当为letters[mid]<=target情况时，只需要统一处理即可
            if (letters[mid] <= target) {
                low = mid + 1;
            } else {
                hig = mid - 1;
            }
        }
        //如果找不到，即low>n，则就返回第1个字符
        return low < n ? letters[low] : letters[0];
    }
}
