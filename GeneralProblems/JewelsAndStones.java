public class JewelsAndStones {
    private static int numJewelsInStones1(String J, String S) {
        int[] lower = new int[26];
        int[] upper = new int[26];
        for (int i=0;i<J.length();i++) {
            char c = J.charAt(i);
            if (Character.isLowerCase(c)) {
                lower[c-'a']++;
            } else {
                upper[c-'A']++;
            }
        }
        int count=0;
        for (int i=0;i<S.length();i++) {
            char c = S.charAt(i);
            if (Character.isLowerCase(c)) {
                if (lower[c-'a']>0) {
                    count++;
                }
            } else {
                if (upper[c-'A']>0) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int numJewelsInStones(String J, String S) {
        int count=0;
        for (int i=0;i<S.length();i++) {
            char c = S.charAt(i);
            if (J.contains(String.valueOf(c))) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";
        System.out.println(numJewelsInStones(J,S));
    }
}
