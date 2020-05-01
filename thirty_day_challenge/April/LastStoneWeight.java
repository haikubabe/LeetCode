package thirty_day_challenge.April;

/**
 * Leetcode - #1046
 */
public class LastStoneWeight
{
    public static int lastStoneWeight(int[] stones) {
        int res = stones.length;
        while (res>1) {
            int max = -1, secondMax = -1;
            int maxIndex = -1, secondMaxIndex = -1;
            for (int i=0;i<stones.length;i++) {
                if (stones[i] >= max)
                {
                    secondMax = max;
                    secondMaxIndex = maxIndex;
                    max = stones[i];
                    maxIndex = i;
                } else if (stones[i] > secondMax && stones[i] < max) {
                    secondMax = stones[i];
                    secondMaxIndex = i;
                }
            }
            if (secondMax == max) {
                stones[secondMaxIndex] = -1;
                stones[maxIndex] = -1;
            } else {
                int diff = max-secondMax;
                stones[secondMaxIndex] = -1;
                stones[maxIndex] = diff;
            }
            res = length(stones);
        }
        if (res != 0) {
            for (int stone : stones) {
                if (stone != -1) {
                    return stone;
                }
            }
        }
        return 0;
    }

    private static int length(int[] stones) {
        int len=0;
        for (int i=0;i<stones.length;i++) {
            if (stones[i]!=-1) {
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args)
    {
        int[] stones = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(stones));
    }
}
