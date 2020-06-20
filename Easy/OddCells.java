package Easy;

/**
 * Leetcode - #1252
 */
public class OddCells
{
    public static int oddCells1(int n, int m, int[][] indices) {
        int[][] matrix = new int[n][m];
        for (int[] index : indices)
        {
            int row = index[0];
            int col = index[1];
            for (int j = 0; j < m; j++)
            {
                matrix[row][j]++;
            }
            for (int j = 0; j < n; j++)
            {
                matrix[j][col]++;
            }
        }
        int odd=0;
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (matrix[i][j]%2 == 1) {
                    odd++;
                }
            }
        }
        return odd;
    }

    public static int oddCells(int n, int m, int[][] indices) {
        int[] rows = new int[n];
        int[] cols = new int[m];
        for (int[] index : indices) {
            rows[index[0]]++;
            cols[index[1]]++;
        }
        int count = 0;
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if ((rows[i] + cols[j]) % 2 == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        int n = 2, m = 3;
        int[][] indices = {
                {0,1},
                {1,1}
        };
        System.out.println(oddCells(n,m,indices));
    }
}
