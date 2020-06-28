package Easy;

/**
 * Leetcode - #1486
 */
public class XOROperation
{
    public static int xorOperation(int n, int start) {
        int res = 0;
        for (int i=0;i<n;i++) {
            res ^= (start + 2 * i);
        }
        return res;
    }

    public static void main(String[] args)
    {
        int n = 10, start = 5;
        System.out.println(xorOperation(n,start));
    }
}
