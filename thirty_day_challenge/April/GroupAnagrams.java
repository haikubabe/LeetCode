package thirty_day_challenge.April;

import java.util.*;

/**
 * Leetcode - #49
 */
public class GroupAnagrams
{

    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            // for each string calculate the count of each character
            // and form a string
            int[] count = new int[26];
            for (int i=0;i<s.length();i++) {
                count[s.charAt(i)-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i=0;i<26;i++) {
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args)
    {
//        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        String[] strs = {"tea","","eat","","tea",""};
        String[] strs = {"tea","and","ace","ad","eat","dans"};
        System.out.println(groupAnagrams(strs));
    }
}
