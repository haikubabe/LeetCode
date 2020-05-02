package thirty_day_challenge.April;

import java.util.*;

public class FirstUnique
{
    private static Map<Integer,Integer> map = new HashMap<>();
    private static Queue<Integer> queue = new LinkedList<>();

    public FirstUnique(int[] nums) {
        for (int num : nums)
        {
            add(num);
        }
    }

    public static int showFirstUnique() {
        while (!queue.isEmpty() && map.get(queue.peek()) >= 2) {
            queue.poll();
        }
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.peek();
    }

    public static void add(int value) {
        map.put(value, map.getOrDefault(value,0)+1);
        queue.add(value);
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
