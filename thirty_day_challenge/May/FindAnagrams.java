package thirty_day_challenge.May;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode - #438
 */
public class FindAnagrams
{
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (p.length() > s.length()) {
            return list;
        }
        for (int i=0;i<=s.length()-p.length();i++) {
            if (isAnagram(p,s.substring(i,i+p.length()))) {
                list.add(i);
            }
        }
        return list;
    }

    private static boolean isAnagram(String p, String s) {
        if (p.isEmpty() && s.isEmpty()) {
            return true;
        }
        if (p.isEmpty() || s.isEmpty()) {
            return false;
        }
        int[] freq = new int[26];
        for (int i=0;i<p.length();i++) {
            freq[p.charAt(i)-'a']++;
        }
        for (int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if (freq[ch-'a'] == 0) {
                return false;
            }
            freq[ch-'a']--;
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
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s,p));
    }
}
