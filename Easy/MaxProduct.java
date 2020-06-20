package Easy;

import java.util.Arrays;

/**
 * Leetcode - #1464
 */
public class MaxProduct
{
    public static int maxProduct2(int[] nums) {
        if (nums.length == 2) {
            return (nums[0] -1) * (nums[1]-1);
        }
        int max = Integer.MIN_VALUE;
        for (int i=0;i<nums.length;i++) {
            for (int j=i+1;j<nums.length;j++) {
                int prod = (nums[i]-1) * (nums[j]-1);
                if (prod > max) {
                    max = prod;
                }
            }
        }
        return max;
    }

    public static int maxProduct1(int[] nums) {
        if (nums.length == 2) {
            return (nums[0] -1) * (nums[1]-1);
        }
        Arrays.sort(nums);
        return (nums[nums.length-2]-1) * (nums[nums.length-1]-1);
    }

    /**
     * Idea - find biggest and second biggest
     */
    public static int maxProduct(int[] nums) {
        if (nums.length == 2) {
            return (nums[0] -1) * (nums[1]-1);
        }
        int max = Integer.MIN_VALUE, secondMax = max;
        for (int i=0;i<nums.length;i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }
        return (max - 1) * (secondMax - 1);
    }

    public static void main(String[] args)
    {
        int[] nums = {1,5,4,5};
        System.out.println(maxProduct(nums));
    }
}
