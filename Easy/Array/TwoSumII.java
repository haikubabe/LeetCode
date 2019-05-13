public class TwoSumII {
    private static int[] twoSum(int[] numbers, int target) {
        int i=0,j=numbers.length-1;
        while (i<j) {
            if (numbers[i]+numbers[j]>target) {
                j--;
            } else if (numbers[i]+numbers[j]==target) {
                return new int[]{i+1,j+1};
            } else {
                i++;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int[] ans = twoSum(numbers,18);
        for (int i=0;i<2;i++) {
            System.out.println(ans[i]);
        }
    }
}
