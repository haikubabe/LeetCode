package thirty_day_challenge.May;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams
{
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int i=0;
        while (i < s.length()) {
            int len = p.length();
            StringBuilder str = new StringBuilder();
            for (int j=i; j < s.length() && len > 0; j++,len--) {
                char ch = s.charAt(j);
                if (p.indexOf(ch) != -1) {
                    str.append(ch);
                } else {
                    break;
                }
            }
            if (str.length() == p.length()) {
                if (isAnagram(p,str.toString())) {
                    list.add(i);
                }
            }
            i++;
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
        String s = "abab";
        String p = "ab";
        System.out.println(findAnagrams(s,p));
    }
}
