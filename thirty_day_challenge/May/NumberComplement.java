package thirty_day_challenge.May;

/**
 * Leetcode - #476
 */
public class NumberComplement
{
    public static int findComplement1(int num) {
        int ans = 0, pos=0;
        while (num != 0) {
            int rem = num%2;
            num /= 2;
            int val = rem ^ 1;
            ans += (val * Math.pow(2,pos));
            pos++;
        }
        return ans;
    }

    public static int findComplement(int num) {
        int ans = 0, pos=0;
        while (num != 0) {
            int last_bit = num & 1;
            num >>= 1;
            int val = last_bit ^ 1;
            ans += (val * Math.pow(2,pos));
            pos++;
        }
        return ans;
    }

    public static void main(String[] args)
    {
        int num = 5;
        System.out.println(findComplement(num));
        System.out.println(~0);
    }
}
