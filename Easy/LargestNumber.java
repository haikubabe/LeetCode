package Easy;

/**
 * Leetcode - #747
 */
public class LargestNumber
{
    public static int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i=0;i<nums.length;i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        for (int i=0;i<nums.length;i++) {
            if (i != index && nums[index] < 2 * nums[i]) {
                return -1;
            }
        }
        return index;
    }

    public static void main(String[] args)
    {
        int[] nums = {3,6,1,0};
        System.out.println(dominantIndex(nums));
    }
}
