public class ShiftingLetters2 {

    public String shiftingLetters(String s, int[][] shifts) {
        final int n = s.length();
        final int[] diff = new int[n];
        for (int i = 0; i < shifts.length; i++) {
            int shift = shifts[i][2] == 1 ? 1 : -1;
            diff[shifts[i][0]] += shift;
            if (shifts[i][1] < n - 1) {
                diff[shifts[i][1] + 1] -= shift;
            }
        }

        final char[] chars = s.toCharArray();
        final StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < n; i++) {
            count = (count + diff[i]) % 26;
            int newChar = chars[i] - 'a' + count;
            if (newChar < 0) {
                newChar += 26;
            } else if (newChar > 25) {
                newChar -= 26;
            }
            sb.append((char) (newChar + 'a'));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        final ShiftingLetters2 test = new ShiftingLetters2();
        System.out.println(test.shiftingLetters("abc", new int[][]{{0, 1, 0}, {1, 2, 1}, {0, 2, 1}}));
        System.out.println(test.shiftingLetters("dztz", new int[][]{{0, 0, 0}, {1, 1, 1}}));
    }

}
