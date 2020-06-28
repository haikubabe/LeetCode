package Easy;

/**
 * Leetcode - #905
 */
public class SortArrayByParity
{
    public static int[] sortArrayByParity(int[] A) {
        for (int i=0,j=0;i<A.length;i++) {
            if (A[i] % 2 == 0) {
                int t = A[i];
                A[i] = A[j];
                A[j++] = t;
            }
        }
        return A;
    }

    public static void main(String[] args)
    {
        int[] A = {5,7,9,4,8,3,2};
        int[] res = sortArrayByParity(A);
        for (int n : res) {
            System.out.print(n + " ");
        }
    }
}
