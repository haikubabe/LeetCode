package thirty_day_challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode -#525
 */
public class ContiguousArray
{
    public static int findMaxLength1st(int[] nums) {
        int maxLength = 0, length = 0;
        int count0,count1;
        for (int i=0;i<nums.length-1;i++) {
            count0 = count1 = 0;
            length = 0;
            if (nums[i] == 0) {
                count0++;
            }
            if (nums[i] == 1) {
                count1++;
            }
            for (int j=i+1;j<nums.length;j++) {
                if (nums[j] == 0) {
                    count0++;
                }
                if (nums[j] == 1) {
                    count1++;
                }
                if (count0 == count1) {
                    length = count0+count1;
                }
            }
            if (length>maxLength) {
                maxLength = length;
            }
        }
        return maxLength;
    }

    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int count = 0, maxLength = 0;
        for (int i=0;i<nums.length;i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxLength = Math.max(maxLength, i-map.get(count));
            } else {
                map.put(count,i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args)
    {
        int[] nums = {0,1};
        System.out.println(findMaxLength(nums));
    }
}
