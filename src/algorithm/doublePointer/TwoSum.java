package algorithm.doublePointer;

/**
 * 判断有数数组的两数之和是否等于目标值
 * 有序==二分
 * 因为有序，所以可以双指针，指针1从前往后遍历，指针2从后往前遍历，通过sum与target对比，判断移动哪个指针
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null) return null;
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }
}
