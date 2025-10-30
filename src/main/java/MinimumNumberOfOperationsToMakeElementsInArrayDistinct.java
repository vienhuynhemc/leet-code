
public class MinimumNumberOfOperationsToMakeElementsInArrayDistinct {

    public int minimumOperations(int[] nums) {
        final boolean[] visited = new boolean[101];

        int end = -1;
        for (int i = nums.length - 1; i > -1; i--) {
            if (!visited[nums[i]]) {
                visited[nums[i]] = true;
                continue;
            }

            end = i;
            break;
        }

        return end == -1 ? 0 : end / 3 + 1;
    }

}
