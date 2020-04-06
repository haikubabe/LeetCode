package exercises;

public class Anagram
{
    private static boolean isAnagram(String s, String t) {
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

    public static void main(String[] args)
    {
        String s = "abc";
        String t = "cab";
        System.out.println(isAnagram(s,t));
    }
}
