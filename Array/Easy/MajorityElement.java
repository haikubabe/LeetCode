public class MajorityElement {
    private static int majorityElement(int[] nums) {
        int candidate=0, count=0;
        for (int i=0;i<nums.length;i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else if (candidate == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        int frequency=0;
        for (int i=0;i<nums.length;i++) {
            if (candidate == nums[i]) {
                frequency++;
            }
        }
        if (frequency>nums.length/2) {
            return candidate;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,2,2,2};
        System.out.println(majorityElement(nums));
    }
}
