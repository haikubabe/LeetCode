import java.util.HashSet;
import java.util.Set;

public class FindSingleNumber {
    private static int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum=0;
        for (int n:nums) {
            set.add(n);
            sum += n;
        }
        int sumOfSet = set.stream().mapToInt(Integer::intValue).sum();
        return 2*sumOfSet-sum;
    }

    public static void main(String[] args) {ture
            
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }
}
