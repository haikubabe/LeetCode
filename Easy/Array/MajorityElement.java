public class MajorityElement {
    private static int majorityElement(int[] nums) {
        int res=-1;
        for (int i=0;i<nums.length;i++) {
            int count=0;
            res=-1;
            for (int j=0;j<nums.length;j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count>nums.length/2) {
                res=nums[i];
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 4, 2, 4, 4, 2, 4};
        System.out.println(majorityElement(nums));
    }
}
