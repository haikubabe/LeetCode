package Amazon;

import java.util.Arrays;

/**
 * Using sorting and Two pointer technique
 */
public class FindPairWithSum
{
    private static boolean findPair(int[] nums, int sum) {
        Arrays.sort(nums);
        int l = 0, r = nums.length-1;
        while (l < r) {
            if (nums[l] + nums[r] == sum) {
                return true;
            }
            if (nums[l] + nums[r] < sum) {
                l++;
            } else {
                r--;
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, -2, 1, 0, 5};
        int sum = 0;
        System.out.println(findPair(nums, sum));
    }
}
