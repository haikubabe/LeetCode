import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCode {
    private static int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for (String str : words) {
            String s = "";
            for (char c:str.toCharArray()) {
                s += codes[c-'a'];
            }
            set.add(s);
        }
        return set.size();
    }

    public static void main(String[] args) {
        String[] words = {};
        System.out.println(uniqueMorseRepresentations(words));
    }
}
