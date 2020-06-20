package Easy;

/**
 * Leetcode - #1460
 */
public class EqualArray
{
    public static boolean canBeEqual(int[] target, int[] arr) {
        int[] count = new int[1001];
        for (int t : target) {
            count[t]++;
        }
        for (int a : arr) {
            if (--count[a] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        int[] target = {1,2,2,3};
        int[] arr = {1,1,2,3};
        System.out.println(canBeEqual(target,arr));
    }
}
