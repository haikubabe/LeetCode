public class FlipAndInvertImage {
    private static int[][] flipAndInvertImage(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        for (int i = 0; i < row; i++) {
            for (int j=0;j<(col+1)/2;j++) {
                int temp = A[i][j]^1;
                A[i][j] = A[i][col-1-j]^1;
                A[i][col-1-j] = temp;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        int[][] res = flipAndInvertImage(A);
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
