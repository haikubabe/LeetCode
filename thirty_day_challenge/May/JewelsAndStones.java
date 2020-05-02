package thirty_day_challenge.May;

/**
 * Leetcode - #771
 */
public class JewelsAndStones
{
    public static int numJewelsInStones(String J, String S) {
        int count = 0;
        for (int i=0;i<S.length();i++) {
            char c = S.charAt(i);
            if (contains(J,c)) {
                count++;
            }
        }
        return count;
    }

    private static boolean contains(String J, char c) {
        for (int i=0;i<J.length();i++) {
            if (J.charAt(i) == c) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        String J = "z";
        String S = "ZZ";
        System.out.println(numJewelsInStones(J,S));
    }
}
