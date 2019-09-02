public class FindMissingNumber {
    private static int missingNumber(int[] nums) {
        boolean[] present = new boolean[nums.length+1];
        for (int num : nums) {
            present[num] = true;
        }
        for (int i=0;i<present.length;i++) {
            if (!present[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3,0,1};
        System.out.println(missingNumber(nums));
    }
}
