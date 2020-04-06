package exercises;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumLeetcode
{
    private static int binarySearch(int[] nums, int n, int low, int high) {
        while (low <= high) {
            int mid = (low+high)/2;
            if (nums[mid] == n) {
                return mid;
            }
            if (n < nums[mid]) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }

    /**
     * using binary search
     * this will not work for duplicate elements
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);
        for (int i=0;i<arr.length;i++) {
            int index = binarySearch(arr, target-arr[i], i+1, arr.length-1);
            if (index != -1) {
                res[0] = i;
                res[1] = index;
                break;
            }
        }
        for (int i=0;i<res.length;i++) {
            for (int j=0;j<nums.length;j++) {
                if (arr[res[i]] == nums[j]) {
                    res[i] = j;
                    break;
                }
            }
        }
        return res;
    }

    /**
     * using map
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSum1st(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            int x = nums[i];
            int y = target-x;
            if (map.containsKey(y)) {
                return new int[] {map.get(y),i};
            }
            map.put(x,i);
        }
        return new int[] {};
    }

    public static void main(String[] args)
    {
//        int[] nums = {2,7,11,15};
//        int[] nums = {5,2,3};
        int[] nums = {0,4,3,0};
        int[] res = twoSum(nums,0);
        for (int i=0;i<res.length;i++) {
            System.out.print(res[i] + " ");
        }
    }
}
