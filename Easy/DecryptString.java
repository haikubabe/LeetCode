package Easy;

/**
 * Leetcode - #1309
 */
public class DecryptString
{
    public static String freqAlphabets(String s) {
        StringBuilder res = new StringBuilder();
        int i = 0;
        while (i<s.length()) {
            int index = i+2;
            if (index < s.length() && s.charAt(index) == '#') {
                String str = s.substring(i,index);
                char ch = (char) ('a' + (Integer.parseInt(str) - 1));
                res.append(ch);
                i = index+1;
            } else {
                char ch = (char) ('a' + ((s.charAt(i) - '0') - 1));
                res.append(ch);
                i++;
            }
        }
        return res.toString();
    }

    public static void main(String[] args)
    {
        String s = "25#";
        System.out.println(freqAlphabets(s));
    }
}
