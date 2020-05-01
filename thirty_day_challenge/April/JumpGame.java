package thirty_day_challenge.April;

enum Index {
    GOOD, BAD, UNKNOWN
}

public class JumpGame
{
    private static Index[] memo;

    public static boolean canJump1(int[] nums) {
        return DFS(nums,0);
    }

    private static boolean DFS(int[] nums, int index) {
        if(index >= nums.length)
            return false;
        if (index == nums.length-1) {
            return true;
        }
        int u = nums[index];
        if(u >= (nums.length - 1 - index))
            return true;

        for (int i=1;i<=u;i++) {
            if(DFS(nums,index+i))
                return true;
        }
        return false;
    }

    private static boolean canJumpFromPosition(int[] nums, int position) {
        if (memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD;
        }
        int furthestJump = Math.min(position + nums[position], nums.length-1);
        for (int nextPosition = position+1; nextPosition<=furthestJump; nextPosition++) {
            if (canJumpFromPosition(nums,nextPosition)) {
                memo[position] = Index.GOOD;
                return true;
            }
        }
        memo[position] = Index.BAD;
        return false;
    }

    public static boolean canJump(int[] nums) {
        memo = new Index[nums.length];
        for (int i=0;i<nums.length;i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length-1] = Index.GOOD;
        return canJumpFromPosition(nums,0);
    }

    public static void main(String[] args)
    {
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }
}
