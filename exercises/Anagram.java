package exercises;

public class Anagram
{

    /**
     * using two frequency array
     * @param s
     * @param t
     * @return
     */
    private static boolean isAnagram1st(String s, String t) {
        if (s.isEmpty() && t.isEmpty()) {
            return true;
        }
        if (s.isEmpty() || t.isEmpty()) {
            return false;
        }

        int[] freqS = new int[26];
        for (int i=0;i<s.length();i++) {
            freqS[s.charAt(i)-'a']++;
        }
        int[] freqT = new int[26];
        for (int i=0;i<t.length();i++) {
            freqT[t.charAt(i)-'a']++;
        }
        for (int i=0;i<26;i++) {
            if (freqS[i] != freqT[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * using one frequency array
     * @param s
     * @param t
     * @return
     */
    private static boolean isAnagram2nd(String s, String t) {
        if (s.isEmpty() && t.isEmpty()) {
            return true;
        }
        if (s.isEmpty() || t.isEmpty()) {
            return false;
        }

        int[] freq = new int[26];
        for (int i=0;i<s.length();i++) {
            freq[s.charAt(i)-'a']++;
        }
        for (int i=0;i<t.length();i++) {
            int ch = t.charAt(i)-'a';
            if (freq[ch] == 0) {
                freq[ch]++;
            } else {
                freq[ch]--;
            }
        }
        for (int i=0;i<26;i++) {
            if (freq[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * using one frequency array and early exit
     * @param s
     * @param t
     * @return
     */
    private static boolean isAnagram(String s, String t) {
        if (s.isEmpty() && t.isEmpty()) {
            return true;
        }
        if (s.isEmpty() || t.isEmpty()) {
            return false;
        }

        int[] freq = new int[26];
        for (int i=0;i<s.length();i++) {
            freq[s.charAt(i)-'a']++;
        }
        for (int i=0;i<t.length();i++) {
            int ch = t.charAt(i)-'a';
            if (freq[ch] == 0) {
                return false;
            }
            freq[ch]--;
        }
        for (int i=0;i<26;i++) {
            if (freq[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        String s = "and";
        String t = "ade";
        System.out.println(isAnagram(s,t));
    }
}
