package src.main.java;

public class CheckIfOneStringSwapCanMakeStringsEqual {

    public boolean areAlmostEqual(String s1, String s2) {
        int diffCount = 0;
        int length = s1.length();
        int firstDiffIndex = -1;
        int secondDiffIndex = -1;
        for (int i = 0; i < length; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCount++;

                if (firstDiffIndex == -1) {
                    firstDiffIndex = i;
                } else if (secondDiffIndex == -1) {
                    secondDiffIndex = i;
                }
            }

            if (diffCount > 2) {
                return false;
            }
        }

        if (diffCount == 0) {
            return true;
        }
        if (diffCount == 1) {
            return false;
        }

        return s1.charAt(firstDiffIndex) == s2.charAt(secondDiffIndex)
                && s1.charAt(secondDiffIndex) == s2.charAt(firstDiffIndex);
    }

    public static void main(String[] args) {
        final var tester = new CheckIfOneStringSwapCanMakeStringsEqual();
        System.out.println(tester.areAlmostEqual("bank", "kanb"));
        System.out.println(tester.areAlmostEqual("attack", "defend"));
        System.out.println(tester.areAlmostEqual("kelb", "kelb"));
    }

}
