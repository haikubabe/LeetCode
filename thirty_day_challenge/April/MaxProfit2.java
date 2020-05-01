package thirty_day_challenge.April;

/**
 * Leetcode - #122
 */
public class MaxProfit2
{

    /**
     * peek valley approach
     * @param prices
     * @return
     */
    private static int maxProfit1st(int[] prices) {
        int maxProfit = 0;
        int valley, peek;
        int i=0;
        while (i<prices.length-1) {
            while (i<prices.length-1 && prices[i]>=prices[i+1]) {
                i++;
            }
            valley = prices[i];
            while (i<prices.length-1 && prices[i]<=prices[i+1]) {
                i++;
            }
            peek = prices[i];
            maxProfit += peek-valley;
        }
        return maxProfit;
    }

    /**
     * one pass
     * @param prices
     * @return
     */
    private static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i=1;i<prices.length;i++) {
            // always selling price should be more than buying price
            if (prices[i] > prices[i-1]) {
                maxProfit += prices[i]-prices[i-1];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args)
    {
        int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }
}
