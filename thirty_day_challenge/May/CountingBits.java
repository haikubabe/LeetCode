package thirty_day_challenge.May;

/**
 * Leetcode - #338
 */
public class CountingBits
{
    public static int[] countBits(int num) {
        int[] res = new int[num+1];
        res[0] = 0;
        for (int i=1;i<=num;i++) {
            int count = numOfBitsOne(i);
            res[i] = count;
        }
        return res;
    }

    private static int numOfBitsOne(int num) {
        int count = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num >>= 1;
        }
        return count;
    }

    public static void main(String[] args)
    {
        int num = 2;
        int[] res = countBits(num);
        for (int i=0;i<res.length;i++) {
            System.out.println(res[i]);
        }
    }
}
