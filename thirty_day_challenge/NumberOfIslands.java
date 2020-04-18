package thirty_day_challenge;

import java.util.LinkedList;
import java.util.Queue;

import javafx.util.Pair;

/**
 * Leetcode - #200
 */
public class NumberOfIslands
{
    private static boolean[][] explored;

    public static int numIslands(char[][] grid) {
        int row = grid.length;
        int col = 0;
        if (row != 0)
            col = grid[0].length;
        explored = new boolean[row][col];
        int count = 0;
        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                if (grid[i][j] == '1' && !explored[i][j]) {
                    BFS(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void BFS(char[][] grid, int i, int j) {
        explored[i][j] = true;
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(i,j));
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int n_i = pair.getKey();
            int n_j = pair.getValue();
            if (n_j>0) {
                char left = grid[n_i][n_j-1];
                if (left == '1' && !explored[n_i][n_j-1]) {
                    explored[n_i][n_j-1] = true;
                    queue.offer(new Pair<>(n_i,n_j-1));
                }
            }
            if (n_i>0) {
                char top = grid[n_i-1][n_j];
                if (top == '1' && !explored[n_i-1][n_j]) {
                    explored[n_i-1][n_j] = true;
                    queue.offer(new Pair<>(n_i-1,n_j));
                }
            }
            if (n_j<grid[0].length-1) {
                char right = grid[n_i][n_j+1];
                if (right == '1' && !explored[n_i][n_j+1]) {
                    explored[n_i][n_j+1] = true;
                    queue.offer(new Pair<>(n_i,n_j+1));
                }
            }
            if (n_i<grid.length-1) {
                char down = grid[n_i+1][n_j];
                if (down == '1' && !explored[n_i+1][n_j]) {
                    explored[n_i+1][n_j] = true;
                    queue.offer(new Pair<>(n_i+1,n_j));
                }
            }
        }
    }

    public static void main(String[] args)
    {
        char[][] grid = {
                {'1','0','0','0','1'},
                {'0','0','0','0','0'},
                {'0','0','0','0','0'},
                {'1','0','0','0','1'}
        };
        System.out.println(numIslands(grid));
    }
}
