package Easy;

/**
 * Leetcode - #1299
 */
public class ReplaceGreatestElement
{
    public static int[] replaceElements(int[] arr) {
        int max = -1;
        for (int i=arr.length-1;i>=0;i--) {
            int temp = arr[i];
            arr[i] = max;
            max = Math.max(temp, max);
        }
        return arr;
    }

    public static void main(String[] args)
    {
        int[] arr = {17,18,5,4,6,1};
        int[] res = replaceElements(arr);
        for (int n : res) {
            System.out.print(n + " ");
        }
    }
}
