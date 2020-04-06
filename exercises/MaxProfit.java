package exercises;

/**
 * Leetcode - #121
 */
public class MaxProfit
{

    /**
     * brute force
     * @param prices
     * @return
     */
    private static int maxProfit1st(int[] prices) {
        int maxProfit = 0;
        for (int i=0;i<prices.length-1;i++) {
            for (int j=i+1;j<prices.length;j++) {
                if (prices[j]-prices[i]>maxProfit) {
                    maxProfit = prices[j]-prices[i];
                }
            }
        }
        return maxProfit;
    }

    /**
     * one pass
     * @param prices
     * @return
     */
    private static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i=0;i<prices.length;i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                if (prices[i]-minPrice > maxProfit) {
                    maxProfit = prices[i]-minPrice;
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args)
    {
//        int[] prices = {7,1,5,3,6,4};
//        int[] prices = {7,6,4,3,1};
//        int[] prices = {2,4,1};
        int[] prices = {2,1,4};
        System.out.println(maxProfit(prices));
    }
}
