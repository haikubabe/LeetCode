import java.util.ArrayList;
import java.util.List;

public class CommonChars {
    private static List<String> commonChars (String[] A) {
        List<String> stringList = new ArrayList<>();
        int[] ans = new int[26];
        String str = A[0];
        for (int i=0;i<str.length();i++) {
            ans[str.charAt(i)-'a']++;
        }
        for (int i=1;i<A.length;i++) {
            String s = A[i];
            int[] count = new int[26];
            for (int j=0;j<s.length();j++) {
                count[s.charAt(j)-'a']++;
            }
            for (int j=0;j<26;j++) {
                ans[j] = (ans[j]<=count[j])?ans[j]:count[j];
            }
        }
        for (int i=0;i<26;i++) {
            int times = ans[i];
            while (times>0) {
                char ch = (char)('a'+i);
                stringList.add(Character.toString(ch));
                times--;
            }
        }
        return stringList;
    }

    public static void main(String[] args) {
        String[] A = {"cool", "lock", "cook"};
        System.out.println(commonChars(A));
    }
}
