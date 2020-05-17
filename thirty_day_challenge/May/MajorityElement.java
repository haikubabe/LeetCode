package thirty_day_challenge.May;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode - #169
 */
public class MajorityElement
{

    public static int majorityElement(int[] nums) {
        Map<Integer,Integer> freq = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
        }
        for (int num : freq.keySet()) {
            if (freq.get(num) > nums.length/2) {
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
}
