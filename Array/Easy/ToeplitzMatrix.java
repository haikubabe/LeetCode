public class ToeplitzMatrix {
    private static boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int r=0;r<row;r++) {
            for (int c=0;c<col;c++) {
                if (r>0 && c>0 && matrix[r][c]!=matrix[r-1][c-1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        System.out.println(isToeplitzMatrix(matrix));
    }
}
