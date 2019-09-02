import java.util.ArrayList;
import java.util.List;

public class Anagrams {
    private static List<Integer> findAnagrams(String s, String p) {
        List<Integer> index = new ArrayList<>();
        if (s.length() == 0) {
            return index;
        }
        int len = p.length();
        int sumP = 0;
        for (int i=0;i<len;i++) {
            sumP += (int)p.charAt(i);
        }
        for (int i=0;i<i+len && i+len!=s.length();i++) {
            int sumS = (int)s.charAt(i);
            for (int j=i+1;j<i+len;j++) {
                sumS += (int)s.charAt(j);
                if (sumS == sumP) {
                    index.add(i);
                    break;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s,p));
    }
}
