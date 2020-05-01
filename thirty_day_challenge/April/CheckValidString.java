package thirty_day_challenge.April;

/**
 * Leetcode - #678
 */
public class CheckValidString
{
    public static boolean checkValidString(String s) {
        int lo = 0, hi = 0;
        for (char c: s.toCharArray()) {
            lo += c == '(' ? 1 : -1;
            hi += c != ')' ? 1 : -1;
            if (hi < 0) break;
            lo = Math.max(lo, 0);
        }
        return lo == 0;
    }

    public static void main(String[] args)
    {
        String s = "(***)";
        System.out.println(checkValidString(s));
    }
}
