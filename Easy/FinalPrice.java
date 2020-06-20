package Easy;

import java.util.Stack;

/**
 * Leetcode - #1475
 */
public class FinalPrice
{
    public static int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<prices.length;i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                prices[stack.pop()] -= prices[i];
            }
            stack.push(i);
        }
        return prices;
    }

    public static void main(String[] args)
    {
        int[] prices = {8,4,6,2,3};
        int[] res = finalPrices(prices);
        for (int n : res) {
            System.out.print(n + " ");
        }
    }
}
