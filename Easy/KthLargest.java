package Easy;

/**
 * Leetcode - #703
 */
public class KthLargest
{
    private int[] minHeap;
    private int index;
    private int heapSize;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.minHeap = new int[k];
        this.index = -1;
        this.heapSize = 0;
        this.k = k;
        createMinPriorityQueue(nums);
        for (int i=k;i<nums.length;i++) {
            add(nums[i]);
        }
    }

    private void createMinPriorityQueue(int[] nums) {
        for (int i=0;i<nums.length && i<k;i++) {
            int val = nums[i];
            addElement(++index, val);
        }
    }

    private void addElement(int index, int val) {
        minHeap[index] = val;
        heapSize++;
        int parentIndex = Math.floorDiv(index-1,2);
        while (index > 0 && minHeap[parentIndex] > minHeap[index]) {
            int temp = minHeap[index];
            minHeap[index] = minHeap[parentIndex];
            minHeap[parentIndex] = temp;
            index = parentIndex;
            parentIndex = Math.floorDiv(index-1,2);
        }
    }

    public int add(int val) {
        if (heapSize < k) {
            addElement(++index, val);
        } else if (val > minHeap[0]) {
            minHeap[0] = val;
            minHeapify(0);
        }
        return minHeap[0];
    }

    private void minHeapify(int index) {
        if (index >= minHeap.length/2) {
            return;
        }
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;
        int smallest = index;
        if (leftIndex < minHeap.length && minHeap[leftIndex] < minHeap[index]) {
            smallest = leftIndex;
        }
        if (rightIndex < minHeap.length && minHeap[rightIndex] < minHeap[smallest]) {
            smallest = rightIndex;
        }
        if (smallest != index) {
            int temp = minHeap[index];
            minHeap[index] = minHeap[smallest];
            minHeap[smallest] = temp;
            minHeapify(smallest);
        }
    }
    public static void main(String[] args)
    {
        int[] nums = {4,5,8,2};
        int k = 2;
        KthLargest kthLargest = new KthLargest(k, nums);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}
