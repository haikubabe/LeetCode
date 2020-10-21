package Amazon;

public class KthLargestArray
{
    private static int findKthLargest(int[] nums, int k) {
        //create a min heap of size k
        buildMinHeap(nums, k);
        for (int i=k;i<nums.length;i++) {
            if (nums[i] > nums[0]) {
                nums[0] = nums[i];
                minHeapify(nums, k, 0);
            }
        }
        return nums[0];
    }

    private static void buildMinHeap(int[] nums, int size) {
        for (int i=size/2-1;i>=0;i--) {
            minHeapify(nums, size, i);
        }
    }

    private static void minHeapify(int[] nums, int size, int index) {
        if (index >= size/2) {
            return;
        }
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;
        int smallest = index;
        if (leftIndex < size && nums[leftIndex] < nums[index]) {
            smallest = leftIndex;
        }
        if (rightIndex < size && nums[rightIndex] < nums[smallest]) {
            smallest = rightIndex;
        }
        if (smallest != index) {
            int temp = nums[index];
            nums[index] = nums[smallest];
            nums[smallest] = temp;
            minHeapify(nums, size, smallest);
        }
    }

    public static void main(String[] args)
    {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }
}
