package exercises;

public class StringPermutation
{
    private static void generatePermutation(String s) {
        permute(s,0,s.length()-1);
    }

    private static String swap(String s, int l, int r) {
        if (l == r) {
            return s;
        }
        char[] ch = s.toCharArray();
        char temp = ch[l];
        ch[l] = ch[r];
        ch[r] = temp;
        return String.valueOf(ch);
    }

    private static void permute(String s, int l, int r) {
        if (l == r) {
            System.out.println(s);
        } else {
            for (int i=l;i<=r;i++) {
                s = swap(s,l,i);
                permute(s,l+1,r);
                s = swap(s,l,i);
            }
        }
    }

    public static void main(String[] args)
    {
        generatePermutation("abc");
    }
}
