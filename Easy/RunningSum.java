package Easy;

/**
 * Leetcode - #5453
 */
public class RunningSum
{
    public static int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for (int i=1;i<nums.length;i++) {
            res[i] = res[i-1] + nums[i];
        }
        return res;
    }

    public static void main(String[] args)
    {
        int[] nums = {1,2,3,4};
        int[] res = runningSum(nums);
        for (int n : res) {
            System.out.print(n + " ");
        }
    }
}
