package Easy;

/**
 * Leetcode - #977
 */
public class SquareSortedArray
{
    public static int[] sortedSquares(int[] A) {
        int posStartIndex = 0;
        while (posStartIndex < A.length && A[posStartIndex] < 0) {
            posStartIndex++;
        }
        int[] res = new int[A.length];
        int t = 0;
        int negEndIndex = posStartIndex-1;
        while (negEndIndex >= 0 && posStartIndex < A.length) {
            if (A[negEndIndex] * A[negEndIndex] < A[posStartIndex] * A[posStartIndex]) {
                res[t++] = A[negEndIndex] * A[negEndIndex];
                negEndIndex--;
            } else {
                res[t++] = A[posStartIndex] * A[posStartIndex];
                posStartIndex++;
            }
        }
        while (negEndIndex >= 0) {
            res[t++] = A[negEndIndex] * A[negEndIndex];
            negEndIndex--;
        }
        while (posStartIndex < A.length) {
            res[t++] = A[posStartIndex] * A[posStartIndex];
            posStartIndex++;
        }
        return res;
    }

    public static void main(String[] args)
    {
        int[] A = {-3,-3,-2,1};
        int[] res = sortedSquares(A);
        for (int n : res) {
            System.out.print(n + " ");
        }
    }
}
