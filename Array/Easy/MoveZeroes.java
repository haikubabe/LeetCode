public class MoveZeroes {
    private static int[] moveZeroes(int[] nums) {
        int n = nums.length;
        int i=0, j=i+1;
        while (i<n && j<n) {
            if (nums[i]==0 && nums[j]!=0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            if (nums[i]!=0 && nums[j]!=0) {
                i++;
                j++;
                continue;
            }
            if (nums[i]!=0) {
                i++;
            }
            if (nums[j]==0) {
                j++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12,8,0,10,0};
        int[] res = moveZeroes(nums);
        for (int i=0;i<res.length;i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}
