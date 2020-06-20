package Easy;

/**
 * Leetcode - #709
 */
public class ToLowerCase
{
    public static String toLowerCase(String str) {
        char[] ch = str.toCharArray();
        for (int i=0;i<str.length();i++) {
            if ('A' <= ch[i] && ch[i] <= 'Z') {
                ch[i] = (char)(ch[i] - 'A' + 'a');
            }
        }
        return String.valueOf(ch);
    }

    public static void main(String[] args)
    {
        String str = "Hello";
        System.out.println(toLowerCase(str));
    }
}
