package thirty_day_challenge.May;

/**
 * Leetcode - #540
 */
public class SingleElement
{
    private static int binarySearch(int[] nums, int low, int high) {
        int ans = -1;
        if (low <= high) {
            int mid = (low + high)/2;
            if (mid == 0 && nums[mid]!=nums[mid+1]) {
                ans = nums[mid];
            } else if (mid == nums.length-1 && nums[mid]!=nums[mid-1]) {
                ans = nums[mid];
            } else if (mid > 0 && nums[mid-1] != nums[mid] && mid < nums.length-1 && nums[mid+1] != nums[mid]) {
                ans = nums[mid];
            } else {
                ans = binarySearch(nums, low, mid-1);
                if (ans == -1) {
                    ans = binarySearch(nums, mid+1, high);
                }
            }
        }
        return ans;
    }

    public static int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return binarySearch(nums,0,nums.length-1);
    }

    public static void main(String[] args)
    {
        int[] nums = {1};
        System.out.println(singleNonDuplicate(nums));
    }
}
