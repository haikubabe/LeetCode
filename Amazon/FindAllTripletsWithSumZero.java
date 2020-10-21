package Amazon;

import java.util.HashSet;
import java.util.Set;

public class FindAllTripletsWithSumZero
{
    private static boolean findTripletsWithSumZero(int[] nums) {
        boolean found = false;
        for (int i=0;i<nums.length-1;i++) {
            Set<Integer> set = new HashSet<>();
            for (int j=i+1;j<nums.length;j++) {
                int val = -(nums[i] + nums[j]);
                if (set.contains(val)) {
                    System.out.println("Pair : (" + val + ", " + nums[i] + ", " + nums[j] + ")");
                    found = true;
                } else {
                    set.add(nums[j]);
                }
            }
        }
        return found;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, -2, 1, 0, 5};
        System.out.println(findTripletsWithSumZero(nums));
    }
}
