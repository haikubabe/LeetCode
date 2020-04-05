package thirty_day_challenge;

/**
 * Leetcode - #283
 */
public class MoveZeroes
{

    /**
     * Naive approach
     * @param nums
     */
    private static void moveZeroes1st(int[] nums) {
        int[] res = new int[nums.length];
        int l=0,h=nums.length-1;
        for (int i=0;i<nums.length;i++) {
            if (nums[i] != 0) {
                res[l] = nums[i];
                l++;
            } else {
                res[h] = nums[i];
                h--;
            }
        }
        for (int i=0;i<nums.length;i++) {
            nums[i] = res[i];
        }
    }

    /**
     * using two pointers 1st approach
     * @param nums
     */
    private static void moveZeroes2nd(int[] nums) {
        int lastNonZeroFoundAt = 0;
        for (int i=0;i<nums.length;i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i];
            }
        }
        for (int i=lastNonZeroFoundAt;i<nums.length;i++) {
            nums[i] = 0;
        }
    }

    /**
     * using two pointers 2nd approach
     * @param nums
     */
    private static void moveZeroes(int[] nums) {
        int j=0;    // slow pointer
        for (int i=1;i<nums.length;i++) {   // fast pointer
            if (nums[i] != nums[j]) {
                if (nums[j] == 0) {
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }
                j++;
            }
        }
    }

    public static void main(String[] args)
    {
        int[] nums = {2,0,5,7,0,1,4,0,3,12,8,0};
//        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }
}
