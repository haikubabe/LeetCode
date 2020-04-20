package BinarySearch;

/**
 * Leetcode - #1351
 */
public class CountNegatives
{
    private static int binarySearch(int[] arr, int low, int high) {
        int count = 0;
        if (low <= high) {
            int mid = (low+high)/2;
            if (arr[mid] < 0) {
                count++;
                count += binarySearch(arr, low, mid-1);
            }
            count += binarySearch(arr, mid+1, high);
        }
        return count;
    }

    public static int countNegatives(int[][] grid) {
        int count = 0;
        for (int i=0;i<grid.length;i++) {
            count += binarySearch(grid[i], 0, grid[0].length-1);
        }
        return count;
    }

    public static void main(String[] args)
    {
        int[][] grid = {
                {-1}
        };
        System.out.println(countNegatives(grid));
    }
}
