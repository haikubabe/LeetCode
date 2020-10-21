package Medium;

/**
 * Leetcode - #215
 */
public class FindKthLargest
{
    public static int findKthLargest(int[] nums, int k) {
        // build min-heap of size k
        // from the remaining n-k elements check if it is greater than the
        // min element in the min heap, if it is replace the min element with
        // that element
        buildMinHeap(nums, k);
        for (int i=k;i<nums.length;i++) {
            if (nums[i] > nums[0]) {
                int t = nums[0];
                nums[0] = nums[i];
                nums[i] = t;
                minHeapify(nums,k,0);
            }
        }
        return nums[0];
    }

    private static void buildMinHeap(int[] nums, int size) {
        for (int i=size/2-1;i>=0;i--) {
            minHeapify(nums,size,i);
        }
    }

    private static void minHeapify(int[] nums, int size, int index) {
        if (index >= size/2) {
            return;
        }
        int left = 2*index+1;
        int right = 2*index+2;
        int smallest = (left < size) && (nums[left] < nums[index]) ? left : index;
        if (right < size && nums[right] < nums[smallest]) {
            smallest = right;
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
