package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode - #1389
 */
public class TargetArray
{
    public static int[] createTargetArray1(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<nums.length;i++) {
            list.add(index[i],nums[i]);
        }
        int[] arr = new int[nums.length];
        for (int i=0;i<nums.length;i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static int[] createTargetArray(int[] nums, int[] index) {
        int[] res = new int[nums.length];
        Arrays.fill(res,-1);
        for (int i=0;i<nums.length;i++) {
            if (res[index[i]] != -1) {
                shiftElements(res,index[i]);
            }
            res[index[i]] = nums[i];
        }
        return res;
    }

    private static void shiftElements(int[] arr, int index) {
        for (int i=arr.length-2;i>=index;i--) {
            arr[i+1] = arr[i];
        }
    }

    public static void main(String[] args)
    {
        int[] nums = {1,2,3,4,0};
        int[] index = {0,1,2,3,0};
        int[] arr = createTargetArray(nums,index);
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }
}
