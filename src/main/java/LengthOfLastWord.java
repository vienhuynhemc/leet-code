package src.main.java;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        int length = 0;
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i > -1; i--) {
            char curChar = chars[i];
            if (curChar != ' ') {
                length++;
            } else {
                if (length != 0) {
                    break;
                }
            }
        }

        return length;
    }

}
