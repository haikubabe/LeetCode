import java.util.HashSet;
import java.util.Set;

public class FindDuplicateNumber {
    private static int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum=0;
        for (int n:nums) {
            set.add(n);
            sum += n;
        }
        int sumOfSet = set.stream().mapToInt(Integer::intValue).sum();
        return sum-sumOfSet;
    }

    public static void main(String[] args) {
        int[] nums={1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }
}
