package Easy;

/**
 * Leetcode - #1021
 */
public class OutermostParentheses
{
    public static String removeOuterParentheses(String S) {
        char[] ch = S.toCharArray();
        int decompositionStartingIndex = 0;
        int start = 0;
        StringBuilder str = new StringBuilder();
        for (int i=0;i<ch.length;i++)
        {
            if (ch[i] == '(') {
                decompositionStartingIndex++;
            } else {
                decompositionStartingIndex--;
            }
            if (decompositionStartingIndex == 0)
            {
                str.append(S, start + 1, i);
                start = i+1;
            }
        }
        return str.toString();
    }

    public static void main(String[] args)
    {
        String S = "(()())(())(()(()))";
        System.out.println(removeOuterParentheses(S));
    }
}
