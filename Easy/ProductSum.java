package Easy;

/**
 * Leetcode - #1281
 */
public class ProductSum
{
    public static int subtractProductAndSum(int n) {
        int product = 1, sum = 0;
        while (n != 0) {
            int rem = n%10;
            product *= rem;
            sum += rem;
            n /= 10;
        }
        return product-sum;
    }

    public static void main(String[] args)
    {
        int n = 4421;
        System.out.println(subtractProductAndSum(n));
    }
}
