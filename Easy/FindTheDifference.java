package Easy;

public class FindTheDifference
{
    public static char findTheDifference1(String s, String t) {
        int sSum = 0, tSum = 0;
        for (int i=0,j=0;i<s.length() && j<t.length(); i++,j++) {
            sSum += s.charAt(i);
            tSum += t.charAt(j);
        }
        tSum += t.charAt(t.length()-1);
        return (char) (tSum - sSum);
    }

    public static char findTheDifference(String s, String t) {
        int len = t.length();
        char res = t.charAt(len-1);
        for (int i=0;i<len-1;i++) {
            res ^= s.charAt(i);
            res ^= t.charAt(i);
        }
        return res;
    }

    public static void main(String[] args)
    {
        String s = "ae", t = "aea";
        System.out.println(findTheDifference(s,t));
    }
}
