public class ValidPalindrome {
    private static boolean isPalindrome(String s) {
        int i=0,j=s.length()-1;
        while (i<s.length() && j>=0){
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if (!Character.isLetterOrDigit(c1)) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(c2)) {
                j--;
                continue;
            }
            if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "89abc ba98";
        System.out.println(isPalindrome(s));
    }
}
