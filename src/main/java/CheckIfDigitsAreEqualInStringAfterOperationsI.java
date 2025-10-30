
import java.util.LinkedList;
import java.util.List;

public class CheckIfDigitsAreEqualInStringAfterOperationsI {

    public boolean hasSameDigits(String s) {
        List<Integer> digits = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            digits.add(s.charAt(i) - '0');
        }

        while (digits.size() > 2) {
            final List<Integer> temp = new LinkedList<>();

            Integer prev = null;
            for (Integer digit : digits) {
                if (prev == null) {
                    prev = digit;
                    continue;
                }

                final int newValue = (prev + digit) % 10;
                prev = digit;
                temp.add(newValue);
            }

            digits = temp;
        }

        return digits.get(0).equals(digits.get(1));
    }
}
