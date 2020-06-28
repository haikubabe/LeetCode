package Hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Leetcode - #1172
 */
public class DinnerPlates
{
    private Map<Integer, Stack<Integer>> map;
    private int pushIndex;
    private int popIndex;
    private int capacity;

    public DinnerPlates(int capacity) {
        this.map = new HashMap<>();
        this.pushIndex = 0;
        this.popIndex = 0;
        this.capacity = capacity;
    }

    public void push(int val) {
        while (map.containsKey(pushIndex) && map.get(pushIndex).size() == capacity) {
            pushIndex++;
        }
        if (!map.containsKey(pushIndex)) {
            map.put(pushIndex, new Stack<>());
        }
        popIndex = Math.max(pushIndex, popIndex);
        map.get(pushIndex).push(val);
    }

    public int pop() {
        if (map.size() == 0) {
            return -1;
        }
        while (map.containsKey(popIndex) && map.get(popIndex).size() == 0) {
            popIndex--;
        }
        if (popIndex == -1) {
            return -1;
        }
        pushIndex = Math.min(pushIndex, popIndex);
        return map.get(popIndex).pop();
    }

    public int popAtStack(int index) {
        if (map.size() == 0 || index >= map.size() || map.get(index).size() == 0) {
            return -1;
        }
        pushIndex = Math.min(pushIndex, index);
        return map.get(index).pop();
    }

    public static void main(String[] args)
    {
        DinnerPlates dinnerPlates = new DinnerPlates(2);
        dinnerPlates.push(1);
        dinnerPlates.push(2);
        dinnerPlates.push(3);
        dinnerPlates.push(4);
        dinnerPlates.push(5);
        System.out.println(dinnerPlates.popAtStack(0));
        dinnerPlates.push(20);
        dinnerPlates.push(21);
        System.out.println(dinnerPlates.popAtStack(0));
        System.out.println(dinnerPlates.popAtStack(2));
        System.out.println(dinnerPlates.pop());
        System.out.println(dinnerPlates.pop());
        System.out.println(dinnerPlates.pop());
        System.out.println(dinnerPlates.pop());
        System.out.println(dinnerPlates.pop());
    }
}
