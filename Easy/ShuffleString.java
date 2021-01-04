package Easy;

public class ShuffleString
{
    public static String restoreString(String s, int[] indices) {
        char[] ch = new char[indices.length];
        for (int i=0,j=0; i<s.length()&&j<indices.length; i++,j++) {
            ch[indices[j]] = s.charAt(i);
        }
        return String.valueOf(ch);
    }

    public static void main(String[] args)
    {
        String s = "codeleet";
        int[] indices = {4,5,6,7,0,2,1,3};
        System.out.println(restoreString(s,indices));
    }
}
