package thirty_day_challenge;

/**
 * Leetcode - #33
 */
public class SearchRotatedSortedArray
{
    private static int binarySearch(int[] nums, int low, int high, int target) {
        if (low <= high) {
            int mid = (low+high)/2;
            if (target == nums[mid]) {
                return mid;
            }
            // in sorted order
            if (nums[low] < nums[mid]) {
                if (nums[low] <= target  && target <= nums[mid]) {
                    return binarySearch(nums, low, mid-1, target);
                }
            }
            // in sorted order
            if (nums[mid] < nums[high]) {
                if (nums[mid] <= target && target <= nums[high]) {
                    return binarySearch(nums,mid+1,high,target);
                }
            }
            // not in order
            if (nums[low] > nums[mid]) {
                return binarySearch(nums, low, mid-1, target);
            }
            // not in order
            if (nums[mid] > nums[high]) {
                return binarySearch(nums, mid+1, high, target);
            }
        }
        return -1;
    }

    public static int search(int[] nums, int target) {
        return binarySearch(nums,0,nums.length-1,target);
    }

    public static void main(String[] args)
    {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums,4));
    }
}
