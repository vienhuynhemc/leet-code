
public class AlternatingGroupsII {

    public int numberOfAlternatingGroups(int[] colors, int k) {
        int ans = 0;

        int end = colors.length + k - 1;
        int prev = colors[0];
        int noChecked = 1;
        int noValid = 1;

        int index = 1;
        while (noChecked < end) {
            if (index == colors.length) {
                index = 0;
            }

            if (colors[index] != prev) {
                noValid++;
            } else {
                noValid = 1;
            }

            if (noValid >= k) {
                ans++;
            }

            prev = colors[index];

            index++;
            noChecked++;
        }

        return ans;
    }

    public static void main(String[] args) {
        final AlternatingGroupsII tester = new AlternatingGroupsII();
        System.out.println(tester.numberOfAlternatingGroups(new int[]{0, 1, 0, 1, 0}, 3));
    }

}
