import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {
    private static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i=0;i<nums.length;i++) {
            int val = nums[i];
            if (nums[Math.abs(val)-1]>0) {
                nums[Math.abs(val)-1] = -nums[Math.abs(val)-1];
            } else {
                res.add(Math.abs(val));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(nums));
    }
}
