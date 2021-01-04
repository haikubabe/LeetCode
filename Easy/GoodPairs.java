package Easy;

public class GoodPairs
{

    /**
     * 1st approach - two loops
     * @param nums
     * @return
     */
    public static int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i=0;i<nums.length-1;i++) {
            for (int j=i+1;j<nums.length;j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 2nd approach - (count * (count-1))/2
     * @param nums
     * @return
     */
    public static int numIdenticalPairs1(int[] nums) {
        int count = 0;
        int[] c = new int[101];
        for (int i=0;i<nums.length;i++) {
            c[nums[i]]++;
        }
        for (int i=0;i<101;i++) {
            count += (c[i] * (c[i]-1))/2;
        }
        return count;
    }

    public static void main(String[] args)
    {
        int[] nums = {1,1,1,1};
        System.out.println(numIdenticalPairs1(nums));
    }
}
