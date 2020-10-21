package Amazon;

import java.util.Arrays;

public class FindAllTripletsWithSumZero1st
{
    private static boolean findTripletsWithSumZero(int[] nums) {
        boolean found = false;
        Arrays.sort(nums);
        for (int c=nums.length-1; c>=2; c--) {
            int a = 0;
            int b = c-1;
            while (a < b) {
                if (nums[a] + nums[b] + nums[c] == 0) {
                    found = true;
                    System.out.println("Pair : (" + nums[a] + ", " + nums[b] + ", " + nums[c] + ")");
                    break;
                } else if (nums[a] + nums[b] + nums[c] < 0) {
                    a++;
                } else {
                    b--;
                }
            }
        }
        return found;
    }

    public static void main(String[] args)
    {
        int[] nums = {0, -1, 2, -3, 1};
        System.out.println(findTripletsWithSumZero(nums));
    }
}
