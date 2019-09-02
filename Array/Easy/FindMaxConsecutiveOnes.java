public class FindMaxConsecutiveOnes {
    private static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count=0;
        for (int i=0;i<nums.length;i++) {
            if (nums[i]%2==1) {
                count++;
                max = max>=count?max:count;
            } else {
                count=0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
