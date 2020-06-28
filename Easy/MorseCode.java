package Easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode - #804
 */
public class MorseCode
{
    public static int uniqueMorseRepresentations(String[] words) {
        String[] morseCodes = {
                ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
        };
        Set<String> wordSet = new HashSet<>();
        for (String w : words) {
            StringBuilder str = new StringBuilder();
            for (int i=0;i<w.length();i++) {
                str.append(morseCodes[w.charAt(i)-'a']);
            }
            wordSet.add(str.toString());
        }
        return wordSet.size();
    }

    public static void main(String[] args)
    {
        String[] words = {
                "gin",
                "zen",
                "gig",
                "msg"
        };
        System.out.println(uniqueMorseRepresentations(words));
    }
}
