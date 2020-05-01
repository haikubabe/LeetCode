package thirty_day_challenge.April;

import java.util.*;

public class FirstUnique
{
    private static Set<Integer> set = new HashSet<>();

    public FirstUnique(int[] nums) {
        for (int num : nums)
        {
            set.add(num);
        }
    }

    public static int showFirstUnique() {
        for (int num : set) {
            return num;
        }
        return -1;
    }

    public static void add(int value) {
        set.add(value);
    }

    public static void main(String[] args)
    {
        int[] nums = {2,3,5};
        FirstUnique firstUnique = new FirstUnique(nums);
        System.out.println(firstUnique.showFirstUnique());
        firstUnique.add(5);
        System.out.println(firstUnique.showFirstUnique());
        firstUnique.add(2);
        System.out.println(firstUnique.showFirstUnique());
        firstUnique.add(3);
        System.out.println(firstUnique.showFirstUnique());
    }
}
