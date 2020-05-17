package thirty_day_challenge.May;

/**
 * Leetcode - #997
 */
public class FindTownJudge
{
    public static int findJudge(int N, int[][] trust) {
        int[] trusts = new int[N];
        int[] trusted = new int[N];
        for (int i=0;i<trust.length;i++) {
            int a = trust[i][0];
            int b = trust[i][1];
            trusts[a-1]++;
            trusted[b-1]++;
        }
        for (int i=0;i<N;i++) {
            if (trusts[i] == 0 && trusted[i] == N-1) {
                return i+1;
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int N = 3;
        int[][] trust = {
                {1,3},
                {2,3},
                {3,1}
        };
        System.out.println(findJudge(N,trust));
    }
}
