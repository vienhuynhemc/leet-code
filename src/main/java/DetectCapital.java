package src.main.java;

public class DetectCapital {

    public boolean detectCapitalUse(String word) {
        boolean firstLetterIsCapital = false;
        int countCapitalLetters = 0;
        for (int i = 0; i < word.length(); i++)
            if (isCapitalChar(word.charAt(i))) {
                countCapitalLetters++;
                if (i == 0)
                    firstLetterIsCapital = true;
            }
        return firstLetterIsCapital && countCapitalLetters == 1
                || countCapitalLetters == word.length()
                || countCapitalLetters == 0;
    }

    private boolean isCapitalChar(char c) {
        return c > 64 && c < 91;
    }

    public static void main(String[] args) {
        DetectCapital detectCapital = new DetectCapital();
        System.out.println(detectCapital.detectCapitalUse("USA"));
        System.out.println(detectCapital.detectCapitalUse("FlaG"));
    }

}
