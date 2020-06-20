package Easy;

/**
 * Leetcode - #1221
 */
public class SplitString
{
    public static int balancedStringSplit(String s) {
        int res = 0, count=0;
        for (int i=0;i<s.length();i++) {
            count += (s.charAt(i) == 'L') ? 1 : -1;
            if (count == 0) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args)
    {
        String s = "RLRRRLLRLL";
        System.out.println(balancedStringSplit(s));
    }
}
