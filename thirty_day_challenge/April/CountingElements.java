package thirty_day_challenge.April;

import java.util.HashSet;
import java.util.Set;

public class CountingElements
{
    private static int countElements(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<arr.length;i++) {
            set.add(arr[i]);
        }
        int count=0;
        for (int i=0;i<arr.length;i++) {
            int n = arr[i]+1;
            if (set.contains(n)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        int[] arr = {1,1,2,2};
        System.out.println(countElements(arr));
    }
}
