package Amazon;

/**
 * Using Min Heap
 */
public class KthLargestInStream1st
{
    private int[] minHeap;
    private int size;
    private int k;
    private int index;

    public KthLargestInStream1st(int k, int[] nums) {
        this.minHeap = new int[k];
        this.size = 0;
        this.k = k;
        this.index = -1;
        createMinHeap(nums);
        //check whether from the remaining elements in the nums array
        //you have to add any element into the min heap
        for (int i=k;i<nums.length;i++) {
            add(nums[i]);
        }
    }

    //create a min heap of size k
    private void createMinHeap(int[] nums) {
        for (int i=0; i<nums.length && i<k; i++) {
            addElementToMinHeap(++index, nums[i]);
        }
    }

    private void addElementToMinHeap(int index, int val) {
        minHeap[index] = val;
        size++;
        int parentIndex = Math.floorDiv(index-1, 2);
        while (index > 0 && minHeap[index] < minHeap[parentIndex]) {
            int temp = minHeap[index];
            minHeap[index] = minHeap[parentIndex];
            minHeap[parentIndex] = temp;
            index = parentIndex;
            parentIndex = Math.floorDiv(index-1, 2);
        }
    }

    private int add(int val) {
        if (size < k) {
            addElementToMinHeap(++index, val);
        } else if (val > minHeap[0]) {
            minHeap[0] = val;
            minHeapify(0);
        }
        return minHeap[0];
    }

    private void minHeapify(int index) {
        // For leaf nodes no need to min heapify
        if (index >= size/2) {
            return;
        }
        // For non-leaf nodes minHeap[0 .. size-1/2]
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;
        int smallest = index;
        if (leftIndex < size && minHeap[leftIndex] < minHeap[index]) {
            smallest = leftIndex;
        }
        if (rightIndex < size && minHeap[rightIndex] < minHeap[smallest]) {
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
        int k=3;
        KthLargestInStream1st kthLargestInStream1st = new KthLargestInStream1st(k, nums);
        System.out.println(kthLargestInStream1st.add(3));
        System.out.println(kthLargestInStream1st.add(5));
        System.out.println(kthLargestInStream1st.add(10));
        System.out.println(kthLargestInStream1st.add(9));
        System.out.println(kthLargestInStream1st.add(4));
    }
}
