import java.util.Arrays;

public class SquaresOfSortedArray {
    private static int[] sortedSquares(int[] A) {
        int n = A.length;
        for (int i=0;i<n;i++) {
            A[i] = A[i]*A[i];
        }
        Arrays.sort(A);
        return A;
    }

    private static int[] sortedSquares1(int[] A) {
        int n = A.length;
        int[] res = new int[n];
        int i=0, k=0;
        while (i<n && A[i]<0) {
            i++;
        }
        int j=i-1;
        while (j>=0 && i<n) {
            if (A[i]*A[i]<=A[j]*A[j]) {
                res[k++] = A[i]*A[i];
                i++;
            } else {
                res[k++] = A[j]*A[j];
                j--;
            }
        }
        while (j>=0) {
            res[k++] = A[j]*A[j];
            j--;
        }
        while (i<n) {
            res[k++] = A[i]*A[i];
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {-4,-1,0,3,10};
        int[] res = sortedSquares1(a);
        for (int i=0;i<a.length;i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}
