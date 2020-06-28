package Easy;

/**
 * Leetcode - #1370
 */
public class IncDecString
{
    public static String sortString(String s) {
        int[] freq = new int[26];
        for (int i=0;i<s.length();i++) {
            freq[s.charAt(i)-'a']++;
        }
        StringBuilder str = new StringBuilder();
        int count = 0;
        while (count < s.length()) {
            // increasing
            for (int j=0;j<26;j++) {
                if (freq[j] > 0) {
                    str.append((char)(j + 'a'));
                    freq[j]--;
                    count++;
                }
            }
            //decreasing
            for (int j=25;j>=0;j--) {
                if (freq[j] > 0) {
                    str.append((char) (j + 'a'));
                    freq[j]--;
                    count++;
                }
            }
        }
        return str.toString();
    }

    public static void main(String[] args)
    {
        String s = "leetcode";
        System.out.println(sortString(s));
    }
}
