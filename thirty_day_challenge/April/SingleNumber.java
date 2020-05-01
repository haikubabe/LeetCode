package thirty_day_challenge.April;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Leetcode - #136
 */
public class SingleNumber
{

    /**
     * using linear time and space complexity
     * @param nums
     * @return
     */
    private static int singleNumber1st(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        for (int key: map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return 0;
    }

    /**
     * using maths
     * 2(a+b+c)-(a+a+b+b+c)
     * @param nums
     * @return
     */
    private static int singleNumber2nd(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int i=0;i<nums.length;i++) {
            sum += nums[i];
            set.add(nums[i]);
        }
        int setSum = 0;
        for (int n : set) {
            setSum += n;
        }
        return 2*setSum - sum;
    }

    /**
     * using linear time and constant space complexity
     * @param nums
     * @return
     */
    private static int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums)
        {
            res = res ^ num;
        }
        return res;
    }

    public static void main(String[] args)
    {
        int[] nums = {2,1,3,2,1};
        System.out.println(singleNumber(nums));
    }
}
