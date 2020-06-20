package Easy;

/**
 * Leetcode - #1295
 */
public class EvenNumbers
{
    public static int findNumbers1(int[] nums) {
        int evenCount = 0;
        for (int i=0;i<nums.length;i++) {
            int n = nums[i];
            int count = 0;
            while (n>0) {
                count++;
                n /= 10;
            }
            if (count%2==0) {
                evenCount++;
            }
        }
        return evenCount;
    }

    /**
     * simple solution
     */
    public static int findNumbers(int[] nums) {
        int count = 0;
        for (int i=0;i<nums.length;i++) {
            if ((nums[i] > 9 && nums[i] < 100) || (nums[i] > 999 && nums[i] < 10000) || nums[i] == 100000) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        int[] nums = {100000};
        System.out.println(findNumbers(nums));
    }
}
