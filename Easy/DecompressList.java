package Easy;

import java.util.Arrays;

/**
 * Leetcode - #1313
 */
public class DecompressList
{
    public static int[] decompressRLElist1(int[] nums) {
        int len = 0;
        for (int i=0;i<nums.length;i+=2) {
            len += nums[i];
        }
        int[] res = new int[len];
        int k=0;
        for (int i=0;i<nums.length/2;i++) {
            int freq = nums[2*i];
            int val = nums[2*i+1];
            for (int j=0;j<freq&&k<len;j++,k++) {
                res[k] = val;
            }
        }
        return res;
    }

    public static int[] decompressRLElist(int[] nums) {
        int len = 0;
        for (int i=0;i<nums.length;i+=2) {
            len += nums[i];
        }
        int[] res = new int[len];
        int startIndex = 0;
        for (int i=0;i<nums.length;i+=2) {
            Arrays.fill(res, startIndex,startIndex+nums[i], nums[i+1]);
            startIndex += nums[i];
        }
        return res;
    }

    public static void main(String[] args)
    {
        int[] nums = {1,2,3,4};
        int[] res = decompressRLElist(nums);
        for (int n:res) {
            System.out.print(n + " ");
        }
    }
}
