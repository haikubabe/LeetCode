package thirty_day_challenge.May;

import java.util.Stack;

/**
 * Leetcode - #402
 */
public class RemoveKDigits
{
    public static String removeKdigits(String num, int k) {
        if (k == 0) {
            return num;
        }
        if (k == num.length()) {
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<num.length();i++) {
            while (k > 0 && !stack.isEmpty() && num.charAt(i) < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        StringBuilder str = new StringBuilder();
        while (!stack.isEmpty()) {
            str.insert(0,stack.pop());
        }
        if (str.length() == 0) {
            return "0";
        }
        String s = str.toString();
        while (s.length() > 1 && s.charAt(0) == '0') {
            s = s.substring(1);
        }
        return s;
    }

    public static void main(String[] args)
    {
        String num = "112";
        int k = 1;
        System.out.println(removeKdigits(num,k));
    }
}
