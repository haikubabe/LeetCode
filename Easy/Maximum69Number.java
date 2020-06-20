package Easy;

/**
 * Leetcode - 1323
 */
public class Maximum69Number
{
    public static int maximum69Number (int num) {
        int leftMostSixIndex = -1;
        int index = 0;
        int temp = num;
        while (temp > 0) {
            if (temp % 10 == 6) {
                leftMostSixIndex = index;
            }
            temp /= 10;
            index++;
        }
        return (leftMostSixIndex != -1) ? num + 3 * (int) Math.pow(10, leftMostSixIndex) : num;
    }

    public static void main(String[] args)
    {
        int num = 9999;
        System.out.println(maximum69Number(num));
    }
}
