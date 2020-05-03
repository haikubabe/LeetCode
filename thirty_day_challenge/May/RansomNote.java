package thirty_day_challenge.May;

/**
 * Leetcode - #383
 */
public class RansomNote
{
    public static boolean canConstruct1(String ransomNote, String magazine) {
        if (ransomNote.equals("") && !magazine.equals("")) {
            return true;
        }
        if (!ransomNote.equals("") && magazine.equals("")) {
            return false;
        }
        if (ransomNote.equals(magazine)) {
            return true;
        }
        char[] ransom = ransomNote.toCharArray();
        char[] mag = magazine.toCharArray();
        boolean res = false;
        for (int i=0;i<ransom.length;i++) {
            res = false;
            for (int j=0;j<mag.length;j++) {
                if (ransom[i] == mag[j]) {
                    mag[j] = '\0';
                    res = true;
                    break;
                }
            }
            if (!res) {
                break;
            }
        }
        return res;
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.equals("") && !magazine.equals("")) {
            return true;
        }
        if (!ransomNote.equals("") && magazine.equals("")) {
            return false;
        }
        if (ransomNote.equals(magazine)) {
            return true;
        }
        int[] freq = new int[26];
        for (int i=0;i<magazine.length();i++) {
            freq[magazine.charAt(i)-'a']++;
        }
        for (int i=0;i<ransomNote.length();i++) {
            if (freq[ransomNote.charAt(i)-'a'] == 0) {
                return false;
            }
            freq[ransomNote.charAt(i)-'a']--;
        }
        return true;
    }

    public static void main(String[] args)
    {
        String ransomNote = "aa";
        String magazine = "ab";
        System.out.println(canConstruct(ransomNote,magazine));
    }
}
