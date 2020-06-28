package Easy;

/**
 * Leetcode - #832
 */
public class FlippingImage
{
    public static int[][] flipAndInvertImage(int[][] A) {
        for (int i=0;i<A.length;i++) {
            for (int j=0;j<(A.length+1)/2;j++) {
                int t = A[i][j] ^ 1;
                A[i][j] = A[i][A.length-j-1] ^ 1;
                A[i][A.length-j-1] = t;
            }
        }
        return A;
    }

    public static void main(String[] args)
    {
        int[][] A = {
                {1,1,0},
                {1,0,1},
                {0,0,0}
        };
        int[][] res = flipAndInvertImage(A);
        for (int[] r : res) {
            for (int n : r) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
