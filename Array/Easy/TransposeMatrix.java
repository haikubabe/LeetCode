public class TransposeMatrix {
    private static int[][] transpose(int[][] A) {
        int col = A[0].length;
        int row = A.length;
        int[][] res = new int[col][row];
        for (int i=0;i<col;i++) {
            for (int j=0;j<row;j++) {
                res[i][j] = A[j][i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] A = {{1,2,3},{4,5,6}};
        int[][] res = transpose(A);
        for (int i=0;i<res.length;i++) {
            for (int j=0;j<res[0].length;j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
