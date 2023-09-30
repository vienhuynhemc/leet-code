import java.util.Stack;

public class OneTwoThreePattern {

    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int[] min = new int[n];
        min[0] = nums[0];
        for (int i = 1; i < n; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] <= min[i]) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() <= min[i]) {
                stack.pop();
            }

            if (!stack.isEmpty() && stack.peek() < nums[i]) {
                return true;
            }

            stack.push(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        OneTwoThreePattern pattern = new OneTwoThreePattern();
        System.out.println(pattern.find132pattern(new int[]{1, 2, 3, 4}));
        System.out.println(pattern.find132pattern(new int[]{3, 1, 4, 2}));
        System.out.println(pattern.find132pattern(new int[]{-1, 3, 2, 0}));
        System.out.println(pattern.find132pattern(new int[]{26, 16, 36, 16, 36, 10, 80, 10, 6}));
        System.out.println(pattern.find132pattern(new int[]{-2, 1, 2, -2, 1, 2}));
        System.out.println(pattern.find132pattern(new int[]{1, 2, 3, 4, -4, -3, -5, -1}));
    }

}
