package thirty_day_challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode - #64
 */
public class MinimumPathSum
{
    private static int minPathSum = Integer.MAX_VALUE;
    private static int currPathSum = 0;
    private static List<Integer> currPath = new ArrayList<>();
    private static List<Integer> minPath;
    private static int[][] mark;

    public static int minPathSum1(int[][] grid) {
        minPathSumHelper(grid,0,0);
        return minPathSum;
    }

    public static List<Integer> minPath(int[][] grid) {
        minPathSumHelper(grid,0,0);
        return minPath;
    }

    /**
     * backtracking - brute force approach
     * @param grid
     * @param i
     * @param j
     */
    private static void minPathSumHelper(int[][] grid, int i, int j) {
        int current_node = grid[i][j];
        currPathSum += current_node;
        currPath.add(current_node);
        // terminating condition when node is in the bottom right
        if (j == grid[0].length-1 && i == grid.length-1) {
            if (currPathSum < minPathSum) {
                minPathSum = currPathSum;
                minPath = new ArrayList<>();
                minPath.addAll(currPath);
            }
        } else {
            // right side
            if (j < grid[0].length-1) {
                minPathSumHelper(grid,i,j+1);
            }
            // down side
            if (i < grid.length-1) {
                minPathSumHelper(grid,i+1,j);
            }
        }
        currPathSum -= current_node;
        currPath.remove(currPath.size()-1);
    }

    public static int minPathSum(int[][] grid) {
        mark = new int[grid.length][grid[0].length];
        return findMinPathSum(grid, grid.length-1, grid[0].length-1);
    }

    /**
     * memoization - dynamic programming
     * @param grid
     * @param i
     * @param j
     * @return
     */
    private static int findMinPathSum(int[][] grid, int i, int j) {
        int left=Integer.MAX_VALUE, top=Integer.MAX_VALUE;
        // base condition
        if (i == 0 && j == 0) {
            mark[i][j] = grid[i][j];
        } else {
            // if left exists
            if (j > 0) {
                if (mark[i][j-1] != 0) {
                    left = mark[i][j-1];
                } else {
                    left = findMinPathSum(grid,i,j-1);
                }
            }
            // if top exists
            if (i > 0) {
                if (mark[i-1][j] != 0) {
                    top = mark[i-1][j];
                } else {
                    top = findMinPathSum(grid,i-1,j);
                }
            }

            mark[i][j] = Math.min(left,top) + grid[i][j];
        }
        return mark[i][j];
    }

    public static void main(String[] args)
    {
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(minPathSum(grid));
        System.out.println(minPath(grid));
        System.out.println("Printing mark array");
        for (int i=0;i<mark.length;i++) {
            for (int j=0;j<mark[0].length;j++) {
                System.out.print(mark[i][j] + " ");
            }
            System.out.println();
        }
    }
}
