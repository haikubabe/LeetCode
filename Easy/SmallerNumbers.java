package Easy;

/**
 * Leetcode - #1365
 */
public class SmallerNumbers
{
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        for (int i=0;i<nums.length;i++) {
            int smaller = 0;
            for (int j=0;j<i;j++) {
                if (nums[j] < nums[i]) {
                    smaller++;
                }
            }
            for (int j=i+1;j<nums.length;j++) {
                if (nums[j] < nums[i]) {
                    smaller++;
                }
            }
            res[i] = smaller;
        }
        return res;
    }

    public static void main(String[] args)
    {
        int[] nums = {7,7,7,7};
        int[] res = smallerNumbersThanCurrent(nums);
        for (int n : res) {
            System.out.print(n + " ");
        }
    }
}
