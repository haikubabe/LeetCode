package thirty_day_challenge;

public class GroupAnagrams
{

    private static boolean isAnagram(String s, String t) {
        int[] freqS = new int[26];
        for (int i=0;i<s.length();i++) {
            freqS[s.charAt(i)-'a']++;
        }
        return true;
    }

    public static void main(String[] args)
    {

    }
}
