package dataStructure.arrayAndMatrix;

/**
 * 寻找重复数
 * 给定一个包含n+1个整数的数组nums，其数字都在1到n之间（包括1和n），可知至少存在一个重复的整数
 * 假设nums只有一个重复的整数，找出这个重复的数
 * 要求不能修改数组，也不能使用额外的空间
 * 不能修改数组：不能进行排序
 * 不能使用额外空间：不能用hashMap统计
 * input: [1,3,4,2,2]
 * output: 2
 */
public class FindDuplicate {

    //二分查找法
    public int findDuplicate1(int[] nums) {
        int low = 1, hig = nums.length - 1;
        while (low <= hig) {
            int mid = low + (hig - low) / 2;
            int cnt = 0;
            //没有重复元素：nums[0]=1，nums[mid-1]=mid
            //遍历nums，找出所有比mid值小的元素个数
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            //如果low=1，high=n，mid=(1+n)/2
            //如果mid==2，cnt=2(1,2)
            //如果mid==5，cnt=5(1,2,3,4,5)
            //即正常情况下，没有重复元素的情况下，故小于等于mid的元素个数cnt==mid（不存在cnt<mid）
            //故只要cnt>mid，就代表有重复元素，需要调整区间，知道确认了下
            if (cnt > mid) {
                hig = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    //双指针解法，类似于有环链表中寻找出环的入口
    //我们对nums数组通过i指向nums[i]来建图，如果存在重复的target，就起码有有两条指向target的边，整张图就存在环，target就是环的入口，即问题等价与快慢指针
    public int findDuplicate2(int[] nums) {
        //[1,3,4,2,2]，需注意，这里的nums是乱序的
        int slow = nums[0], fast = nums[nums[0]];
        //确认存在环，slow和fast相遇，while跳出时，是两个指针的相遇点
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        //在相遇之后，将slow放置在0，两个指针每次都移动一步，再次的相遇点就是环的入口
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
