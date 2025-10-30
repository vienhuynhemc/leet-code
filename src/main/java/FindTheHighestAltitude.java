
public class FindTheHighestAltitude {

    public int largestAltitude(int[] gain) {
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < gain.length; i++) {
            sum += gain[i];
            if (sum > ans) {
                ans = sum;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        final FindTheHighestAltitude test = new FindTheHighestAltitude();
        System.out.println(test.largestAltitude(new int[]{-5, 1, 5, 0, -7}));
        System.out.println(test.largestAltitude(new int[]{-4, -3, -2, -1, 4, 3, 2}));
    }

}
