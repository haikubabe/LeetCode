package Amazon;

import java.util.Arrays;

/**
 * Using sorting and Two pointer technique
 */
public class PythagoreanTriplet
{
    private static boolean findTriplet(int[] nums) {
        for (int i=0;i<nums.length;i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        for (int c = nums.length-1; c>=2; c--) {
            int a = 0, b = c-1;
            while (a < b) {
                if (nums[a] + nums[b] == nums[c]) {
                    return true;
                }
                if (nums[a] + nums[b] < nums[c]) {
                    a++;
                } else {
                    b--;
                }
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        int[] nums = {3,1,4,6,5};
        System.out.println(findTriplet(nums));
    }
}
