public class MinimumLengthOfStringAfterOperations {

    public int minimumLength(String s) {
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }

        int reduceCount = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 2) {
                reduceCount = reduceCount + (counts[i] % 2 == 1 ? counts[i] - 1 : counts[i] - 2);
            }
        }

        return s.length() - reduceCount;
    }

    public static void main(String[] args) {
        final MinimumLengthOfStringAfterOperations test = new MinimumLengthOfStringAfterOperations();
        System.out.println(test.minimumLength("abaacbcbb"));
        System.out.println(test.minimumLength("aa"));
    }

}
