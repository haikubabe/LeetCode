package Easy;

/**
 * Leetcode - #1374
 */
public class GenerateStringOddCount
{
    public static String generateTheString(int n) {
        StringBuilder str = new StringBuilder();;
        if (n % 2 == 1) {
            for (int i=1;i<=n;i++) {
                str.append("a");
            }
        } else {
            for (int i=1;i<=n-1;i++) {
                str.append("a");
            }
            str.append("b");
        }
        return str.toString();
    }

    public static void main(String[] args)
    {
        int n = 7;
        System.out.println(generateTheString(n));
    }
}
