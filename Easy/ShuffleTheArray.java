package Easy;

/**
 * Leetcode - #1470
 */
public class ShuffleTheArray
{

    /**
     * 1st approach
     * @param nums
     * @param n
     * @return
     */
    public static int[] shuffle1(int[] nums, int n) {
        int[] arr = new int[2*n];
        for (int i=0, j=n, k=0; k<nums.length; i++, j++) {
            arr[k++] = nums[i];
            arr[k++] = nums[j];
        }
        return arr;
    }

    /**
     * 2nd approach
     * If the index of the result array is even then select the elements from the 1st half of the input array
     * else select the elements from the 2nd half of the input array
     */
    public static int[] shuffle(int[] nums, int n) {
        int[] res = new int[2*n];
        for (int i=0;i<nums.length;i++) {
            res[i] = (i%2 == 0) ? nums[i/2] : nums[n + i/2];
        }
        return res;
    }

    public static void main(String[] args)
    {
        int[] nums = {1,1,2,2};
        int n = 2;
        int[] arr = shuffle(nums,n);
        for (int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
