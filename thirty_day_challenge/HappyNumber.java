package thirty_day_challenge;

import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode - #202
 */
public class HappyNumber
{

    private static int digitSquareSum(int n) {
        int squareSum = 0;
        while (n != 0) {
            int rem = n%10;
            n /= 10;
            squareSum = squareSum + (rem * rem);
        }
        return squareSum;
    }

    /**
     * using set to keep track of cycle
     * @param n
     * @return
     */
    private static boolean isHappy1st(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1) {
            int squareSum = digitSquareSum(n);
            if (seen.contains(squareSum)) {
                return false;
            }
            seen.add(squareSum);
            n = squareSum;
        }
        return true;
    }

    /**
     * using floyd cycle detection algorithm
     * @param n
     * @return
     */
    private static boolean isHappy(int n) {
        int slow,fast;
        slow = fast = n;
        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);
            if (fast == 1) {
                return true;
            }
        } while (slow != fast);
        return false;
    }

     public static void main(String[] args)
    {
        System.out.println(isHappy(19));
    }
}
