package thirty_day_challenge.June;

/**
 * Leetcode - #231
 */
public class PowerOfTwo
{
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n-1)) == 0;
    }

    public static void main(String[] args)
    {
        int n = -2147483648;
        System.out.println(isPowerOfTwo(n));
    }
}
