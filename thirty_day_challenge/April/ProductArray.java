package thirty_day_challenge.April;

/**
 * Leetcode - #238
 */
public class ProductArray
{
    public static int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int product = 1;
        for (int i=0;i<nums.length;i++) {
            if (i != 0)
            {
                product = product * nums[i - 1];
            }
            output[i] = product;
        }
        product = 1;
        for (int i=nums.length-1;i>=0;i--) {
            if (i != nums.length-1) {
                product = product * nums[i+1];
            }
            output[i] = output[i] * product;
        }
        return output;
    }

    public static void main(String[] args)
    {
        int[] nums = {1,2,3,4};
        int[] output = productExceptSelf(nums);
        for (int n : output) {
            System.out.print(n + " ");
        }
    }
}
