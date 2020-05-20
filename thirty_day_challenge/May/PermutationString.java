package thirty_day_challenge.May;

/**
 * Leetcode - #567
 */
public class PermutationString
{
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] freq1 = new int[26];
        for (int i=0;i<s1.length();i++) {
            freq1[s1.charAt(i) - 'a']++;
        }
        for (int i=0;i<=s2.length()-s1.length();i++) {
            int[] freq2 = new int[26];
            for (int j=0;j<s1.length();j++) {
                freq2[s2.charAt(i+j) - 'a']++;
            }
            if (matches(freq1,freq2)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Sliding Window Approach
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion1st(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for (int i=0;i<s1.length();i++) {
            freq1[s1.charAt(i)-'a']++;
            freq2[s2.charAt(i)-'a']++;
        }
        for (int i=0;i<s2.length()-s1.length();i++) {
            if (matches(freq1,freq2)) {
                return true;
            }
            freq2[s2.charAt(i+s1.length())-'a']++;
            freq2[s2.charAt(i)-'a']--;
        }
        return matches(freq1,freq2);
    }

    private static boolean matches(int[] freq1, int[] freq2) {
        for (int i=0;i<26;i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        String s1 = "ab", s2 = "eidboaoo";
        System.out.println(checkInclusion1st(s1,s2));
    }
}
