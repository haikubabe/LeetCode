import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            int complement = target-nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] numbers = {2,3,2};
        int[] ans = twoSum(numbers, 4);
        for (int i = 0; i < 2; i++) {
            System.out.println(ans[i]);
        }
    }
}
