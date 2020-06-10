package thirty_day_challenge.June;

import java.util.Arrays;

/**
 * Leetcode - #1029
 */
public class TwoCityScheduling
{
    public static int twoCitySchedCost(int[][] costs) {
        int totalCosts = 0;
        int[] refund = new int[costs.length];
        for (int i=0;i<costs.length;i++) {
            totalCosts += costs[i][0];
            refund[i] = costs[i][1] - costs[i][0];
        }
        Arrays.sort(refund);
        for (int i=0;i<costs.length/2;i++) {
            totalCosts += refund[i];
        }
        return totalCosts;
    }

    public static void main(String[] args)
    {
        int[][] costs = {
                {259,770},
                {448,54},
                {926,667},
                {184,139},
                {840,118},
                {577,469}
        };
        System.out.println(twoCitySchedCost(costs));
    }
}
