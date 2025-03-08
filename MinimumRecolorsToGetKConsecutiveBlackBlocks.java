public class MinimumRecolorsToGetKConsecutiveBlackBlocks {

    public int minimumRecolors(String blocks, int k) {
        int numberOfWhiteNodes = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                numberOfWhiteNodes++;
            }
        }

        int n = blocks.length();
        int numberOfOperations = numberOfWhiteNodes;
        for (int i = k; i < n; i++) {
            if (blocks.charAt(i) == 'W') {
                numberOfOperations++;
            }

            if (blocks.charAt(i - k) == 'W') {
                numberOfOperations--;
            }

            if (numberOfOperations < numberOfWhiteNodes) {
                numberOfWhiteNodes = numberOfOperations;
            }
        }

        return numberOfWhiteNodes;
    }

    public static void main(String[] args) {
        final MinimumRecolorsToGetKConsecutiveBlackBlocks tester = new MinimumRecolorsToGetKConsecutiveBlackBlocks();
        System.out.println(tester.minimumRecolors("WBWBBBW", 2));
    }

}
