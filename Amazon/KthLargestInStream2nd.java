package Amazon;

import java.util.PriorityQueue;

public class KthLargestInStream2nd
{
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargestInStream2nd(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>(k);
        this.k = k;
        for (int n : nums) {
            add(n);
        }
    }

    private int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }

    public static void main(String[] args)
    {
        int[] nums = {4,5,8,2};
        int k=3;
        KthLargestInStream2nd kthLargestInStream2nd = new KthLargestInStream2nd(k, nums);
        System.out.println(kthLargestInStream2nd.add(3));
        System.out.println(kthLargestInStream2nd.add(5));
        System.out.println(kthLargestInStream2nd.add(10));
        System.out.println(kthLargestInStream2nd.add(9));
        System.out.println(kthLargestInStream2nd.add(4));
    }
}
