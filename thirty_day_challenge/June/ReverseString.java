package thirty_day_challenge.June;

/**
 * Leetcode - #344
 */
public class ReverseString
{
    public static void reverseString(char[] s) {
        for (int i=0;i<s.length/2;i++) {
            char ch = s[s.length-1-i];
            s[s.length-1-i] = s[i];
            s[i] = ch;
        }
    }

    public static void main(String[] args)
    {
        char[] s = {'a','b','c','d'};
        reverseString(s);
        System.out.println(s);
    }
}
