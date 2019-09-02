public class MaxProfit {
    private static int maxProfit(int[] prices) {
        int n = prices.length;
        int[] small = new int[n];
        int[] large = new int[n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i=0;i<n;i++) {
            if (prices[i]<min) {
                min = prices[i];
            }
            small[i] = min;
        }
        for (int i=n-1;i>=0;i--) {
            if (prices[i]>max) {
                max = prices[i];
            }
            large[i] = max;
        }
        int maxProfit = 0;
        for (int i=0;i<n;i++) {
            if (large[i]-small[i]>maxProfit) {
                maxProfit = large[i]-small[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {};
        System.out.println(maxProfit(prices));
    }
}
