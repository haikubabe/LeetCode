package Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode - #1431
 */
public class KidWithCandies
{
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i=0;i<candies.length;i++) {
            if (candies[i] > max) {
                max = candies[i];
                index = i;
            }
        }
        List<Boolean> res = new ArrayList<>();
        for (int i=0;i<candies.length;i++) {
            if (candies[i] + extraCandies >= candies[index]) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }

    public static void main(String[] args)
    {
        int[] candies = {12,1,12};
        int extraCandies = 10;
        System.out.println(kidsWithCandies(candies,extraCandies));
    }
}
