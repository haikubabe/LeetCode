package thirty_day_challenge.May;

import java.util.*;

/**
 * Leetcode - #451
 */
public class CharacterSortByFrequency
{
    public static String frequencySort(String s) {
        Map<Character,Integer> frequencyMap = new HashMap<>();
        for (int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch,0)+1);
        }
        MyComparator myComparator = new MyComparator(frequencyMap);
        Map<Character,Integer> treeMap = new TreeMap<>(myComparator);
        treeMap.putAll(frequencyMap);
        StringBuilder str = new StringBuilder();
        for (Map.Entry<Character,Integer> entry : treeMap.entrySet()) {
            int count = entry.getValue();
            while (count > 0) {
                str.append(entry.getKey());
                count--;
            }
        }
        return str.toString();
    }

    static class MyComparator implements Comparator<Character> {

        private Map<Character,Integer> map;

        MyComparator(Map<Character,Integer> map) {
            this.map = map;
        }

        @Override
        public int compare(Character o1, Character o2)
        {
            if (map.get(o2) <= map.get(o1)) {
                return -1;
            } else {
                return 1;
            }
        }
    }
    public static void main(String[] args)
    {
        String s = "tree";
        System.out.println(frequencySort(s));
    }
}
