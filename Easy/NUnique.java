package Easy;

/**
 * Leetcode - #1304
 */
public class NUnique
{
    public static int[] sumZero(int n) {
        int[] arr = new int[n];
        int sum = 0;
        for (int i=1;i<n;i++) {
            arr[i-1] = i;
            sum += i;
        }
        arr[n-1] = -sum;
        return arr;
    }

    public static void main(String[] args)
    {
        int n = 7;
        int[] arr = sumZero(n);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
