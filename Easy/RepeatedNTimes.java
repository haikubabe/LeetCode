package Easy;

/**
 * Leetcode - #961
 */
public class RepeatedNTimes
{
    public static int repeatedNTimes(int[] A) {
        int[] freq = new int[10001];
        for (int i=0;i<A.length;i++) {
            // check more than 1
            freq[A[i]]++;
            if (freq[A[i]] > 1) {
                return A[i];
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[] A = {5,1,5,2,5,3,5,4};
        System.out.println(repeatedNTimes(A));
    }
}
