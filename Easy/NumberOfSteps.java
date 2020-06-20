package Easy;

/**
 * Leetcode - #1342
 */
public class NumberOfSteps
{
    public static int numberOfSteps1(int num) {
        int steps = 0;
        while (num != 0) {
            if (num%2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
            steps++;
        }
        return steps;
    }

    /**
     * Idea - if num is even or 1 then only one step is required '/' for even or '-' for 1
     * else if num is odd two steps are required '-' and '/'
     * @param num
     * @return
     */
    public static int numberOfSteps(int num) {
        int steps = 0;
        while (num != 0) {
            steps += ((num & 1) == 0) || (num == 1) ? 1 : 2;
            num >>= 1;  // divide by 2
        }
        return steps;
    }

    public static void main(String[] args)
    {
        int num = 123;
        System.out.println(numberOfSteps(num));
    }
}
