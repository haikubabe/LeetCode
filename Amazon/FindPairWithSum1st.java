package Amazon;

import java.util.HashSet;
import java.util.Set;

/**
 * Using Hashing
 */
public class FindPairWithSum1st
{
    private static boolean findPair(int[] nums, int sum) {
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<nums.length;i++) {
            int val = sum - nums[i];
            if (set.contains(val)) {
                System.out.println("Pair: (" + nums[i] + ", " + val + ") with sum " + sum);
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args)
    {
        int[] nums = {0, -1, 2, -3, 1};
        int sum = -2;
        System.out.println(findPair(nums, sum));
    }
}
