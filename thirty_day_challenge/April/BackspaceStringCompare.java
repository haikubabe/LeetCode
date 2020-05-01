package thirty_day_challenge.April;

import java.util.Stack;

/**
 * Leetcode - #844
 */
public class BackspaceStringCompare
{

    /**
     * using string builder
     * @param str
     * @return
     */
    private static String buildString1st(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<str.length();i++) {
            char c = str.charAt(i);
            if (c != '#') {
                sb.append(c);
            } else if (sb.length() != 0) {
                sb.delete(sb.length()-1, sb.length());
            }
        }
        return sb.toString();
    }

    /**
     * using stack
     * @param str
     * @return
     */
    private static String buildString(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<str.length();i++) {
            char c = str.charAt(i);
            if (c != '#') {
                stack.push(c);
            } else if (!stack.empty()) {
                stack.pop();
            }
        }
        return String.valueOf(stack);
    }

    private static boolean backspaceCompare(String S, String T) {
        return buildString(S).equals(buildString(T));
    }

    public static void main(String[] args)
    {
        String S = "a##c";
        String T = "#a#b";

        System.out.println(backspaceCompare(S,T));
    }
}
