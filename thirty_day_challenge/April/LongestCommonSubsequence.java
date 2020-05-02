package thirty_day_challenge.April;

/**
 * Leetcode - #1143
 */
public class LongestCommonSubsequence
{
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        char[] X = text1.toCharArray();
        char[] Y = text2.toCharArray();
        int[][] L = new int[m+1][n+1];
        for (int i=0;i<=m;i++) {
            for (int j=0;j<=n;j++) {
                if (i == 0 || j == 0) {
                    L[i][j] = 0;
                } else if (X[i-1] == Y[j-1]) {
                    L[i][j] = 1 + L[i-1][j-1];
                } else {
                    L[i][j] = Math.max(L[i][j-1],L[i-1][j]);
                }
            }
        }
        return L[m][n];
    }

    public static void main(String[] args)
    {
        System.out.println(longestCommonSubsequence("ABCDGH","AEDFHR"));
    }
}
