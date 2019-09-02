import java.util.Arrays;

public class ArrayPartition1 {
    private static int arrayPairSum(int[] nums) {
        int n = nums.length/2;
        int sum=0, count=0, i=0,j=i+1;
        Arrays.sort(nums);
        while (count<n) {
            sum += Math.min(nums[i], nums[j]);
            i = i+2;
            j = j+2;
            count++;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,3,2};
        System.out.println(arrayPairSum(nums));
    }
}
