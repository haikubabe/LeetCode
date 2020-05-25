package exercises;

import java.util.ArrayList;
import java.util.List;

public class ValidPath
{
    private static boolean canMoveLeft;
    private static boolean canMoveRight;
    private static boolean canMoveTop;
    private static boolean canMoveBottom;
    private static List<Integer> path = new ArrayList<>();
    private static List<List<Integer>> paths = new ArrayList<>();

    public static boolean findValidPath(int[][] nums) {
        return findValidPath(nums,0, 0);
    }

    private static boolean findValidPath(int[][] nums, int row, int col) {
        if (row == nums.length-1 && col == nums[0].length-1) {
            return true;
        } else {
            // move left
            if (col - nums[row][col] >= 0) {
                canMoveLeft = findValidPath(nums,row,col-nums[row][col]);
            }
            // move right
            if (col + nums[row][col] <= nums[0].length-1) {
                canMoveRight = findValidPath(nums,row,col + nums[row][col]);
            }
            // move top
            if (row - nums[row][col] >= 0) {
                canMoveTop = findValidPath(nums,row-nums[row][col],col);
            }
            // move bottom
            if (row + nums[row][col] <= nums.length-1) {
                canMoveBottom = findValidPath(nums,row + nums[row][col],col);
            }
        }
        return (canMoveLeft || canMoveRight || canMoveTop || canMoveBottom);
    }

    public static void printValidPath(int[][] nums) {
        printValidPath(nums,0,0);
    }

    private static void printValidPath(int[][] nums, int row, int col) {
        if (row == nums.length-1 && col == nums[0].length-1) {
            path.add(nums[row][col]);
            paths.add(new ArrayList<>(path));
        } else {
            // move left
            if (col - nums[row][col] >= 0) {
                path.add(nums[row][col]);
                printValidPath(nums,row,col-nums[row][col]);
                path.remove(path.size()-1);
            }
            // move right
            if (col + nums[row][col] <= nums[0].length-1) {
                path.add(nums[row][col]);
                printValidPath(nums,row,col + nums[row][col]);
                path.remove(path.size()-1);
            }
            // move top
            if (row - nums[row][col] >= 0) {
                path.add(nums[row][col]);
                printValidPath(nums,row-nums[row][col],col);
                path.remove(path.size()-1);
            }
            // move bottom
            if (row + nums[row][col] <= nums.length-1) {
                path.add(nums[row][col]);
                printValidPath(nums,row + nums[row][col],col);
                path.remove(path.size()-1);
            }
        }
    }

    public static void main(String[] args)
    {
        int[][] nums = {
                {1,2,3},
                {4,5,6},
                {7,1,8}
        };
        System.out.println(findValidPath(nums));
        printValidPath(nums);
        System.out.println(paths);
    }
}
