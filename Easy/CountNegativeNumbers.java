package Easy;

/**
 * Leetcode - #1351
 */
public class CountNegativeNumbers
{
    public static int countNegatives(int[][] grid) {
        int cols = grid[0].length;
        int count = 0;
        for (int[] row : grid)
        {
            // if the first element is negative then all the elements in the row are negative
            if (row[0] < 0)
            {
                count += cols;
                continue;
            }
            // if the last element is positive then there are no negative elements in the row
            if (row[cols - 1] > 0)
            {
                continue;
            }
            // if the first element is not negative or the last element is not positive then there
            // might be some negative elements in the row
            int left = 0, right = cols - 1;
            while (left <= right)
            {
                int mid = left + (right - left) / 2;
                if (row[mid] < 0)
                {
                    right = mid - 1;
                }
                else
                {
                    left = mid + 1;
                }
            }
            // left is the starting index of the first negative element in the row grid
            // after this index in the row grid all the other indices have negative elements
            count += (cols - left);
        }
        return count;
    }

    public static void main(String[] args)
    {
        int[][] grid = {
                {4,3,2,-1},
                {3,2,1,-1},
                {1,1,-1,-2},
                {-1,-1,-2,-3}
        };
        System.out.println(countNegatives(grid));
    }
}
