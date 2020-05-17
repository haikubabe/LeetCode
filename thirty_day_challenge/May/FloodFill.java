package thirty_day_challenge.May;

/**
 * Leetcode - #733
 */
public class FloodFill
{
    private static boolean[][] explored;

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        explored = new boolean[image.length][image[0].length];
        dfs(image, sr, sc, newColor);
        return image;
    }

    private static void dfs(int[][] image, int sr, int sc, int newColor) {
        explored[sr][sc] = true;
        // explore left
        if (sc > 0 && image[sr][sc-1] == image[sr][sc] && !explored[sr][sc-1]) {
            dfs(image, sr, sc-1, newColor);
            image[sr][sc-1] = newColor;
        }
        // explore right
        if (sc < image[0].length-1 && image[sr][sc+1] == image[sr][sc] && !explored[sr][sc+1]) {
            dfs(image, sr, sc+1, newColor);
            image[sr][sc+1] = newColor;
        }
        // explore top
        if (sr > 0 && image[sr-1][sc] == image[sr][sc] && !explored[sr-1][sc]) {
            dfs(image, sr-1, sc, newColor);
            image[sr-1][sc] = newColor;
        }
        // explore bottom
        if (sr < image.length-1 && image[sr+1][sc] == image[sr][sc] && !explored[sr+1][sc]) {
            dfs(image, sr+1, sc, newColor);
            image[sr+1][sc] = newColor;
        }
        image[sr][sc] = newColor;
    }

    public static void main(String[] args)
    {
        int[][] image = {
                {1,1,1},
                {1,1,0},
                {1,0,1},
        };
        int[][] newImage = floodFill(image,1,1,2);
        for (int i=0;i<newImage.length;i++) {
            for (int j=0;j<newImage[0].length;j++) {
                System.out.print(newImage[i][j] + " ");
            }
            System.out.println();
        }
    }
}
