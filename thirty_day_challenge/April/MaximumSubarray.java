package thirty_day_challenge.April;

/**
 * Leetcode - #53
 */
public class MaximumSubarray
{

    /**
     * one pass
     * @param nums
     * @return
     */
    private static int maxSubArray1st(int[] nums) {
        int i=0;
        int n = nums.length;
        int sum = nums[i], maxSum = sum;
        for (int j=i+1;j<n;j++) {
            if (sum < 0) {
                sum = nums[j];
            } else {
                sum += nums[j];
            }
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }

    /**
     * two pass
     * @param nums
     * @return
     */
    private static int maxSubArray2nd(int[] nums) {
        int sum, max = nums[0];
        for (int i=0;i<nums.length;i++) {
            sum = nums[i];
            for (int j=i+1;j<nums.length;j++) {
                sum += nums[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    /**
     * Time Complexity - O(n) using Dynamic Programming
     * @param nums
     * @return
     */
    private static int maxSubArray(int[] nums)
    {
        int current_sum = 0;
        int max_sum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++)
        {
            int new_sum = nums[i];
            //if you encounter a sum which is greater than the existing one then
            //start a new subarray/sequence otherwise continue with the existing subarray/sequence
            current_sum = Math.max(new_sum, current_sum + new_sum);

            if (current_sum > max_sum)
            {
                max_sum = current_sum;
            }
        }
        return max_sum;
    }

    public static void main(String[] args)
    {
        int[] n = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
//        int[] n = {-4,-9,-3,-8,-2,-5,-1,-7};
        System.out.println(maxSubArray(n));
    }
}
