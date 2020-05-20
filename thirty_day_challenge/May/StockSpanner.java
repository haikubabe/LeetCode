package thirty_day_challenge.May;

import java.util.Stack;

/**
 * Leetcode - #901
 */
public class StockSpanner
{
    private Stack<Integer> prices;
    private Stack<Integer> weights;

    public StockSpanner() {
        prices = new Stack<>();
        weights = new Stack<>();
    }

    public int next(int price) {
        int w = 1;
        while (!prices.isEmpty() && prices.peek() <= price) {
            prices.pop();
            w += weights.pop();
        }
        prices.push(price);
        weights.push(w);
        return w;
    }

    public static void main(String[] args)
    {
        StockSpanner s = new StockSpanner();
        System.out.println(s.next(100));
        System.out.println(s.next(80));
        System.out.println(s.next(60));
        System.out.println(s.next(70));
        System.out.println(s.next(60));
        System.out.println(s.next(75));
        System.out.println(s.next(85));
    }
}
