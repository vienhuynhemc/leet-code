
public class ValidNumber {

    public boolean isNumber(String s) {
        if (s.contains("f") || s.contains("D")) {
            return false;
        }
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception ignore) {
        }
        try {
            Double.parseDouble(s);
            return true;
        } catch (Exception ignore) {
            return false;
        }
    }

    public static void main(String[] args) {
        ValidNumber validNumber = new ValidNumber();
        String[] valid = new String[]{"2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"};
        System.out.println("Valid");
        for (String s : valid) {
            System.out.println(s + ": " + validNumber.isNumber(s));
        }
        System.out.println("------------------------------");
        String[] inValid = new String[]{"abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"};
        System.out.println("In valid");
        for (String s : inValid) {
            System.out.println(s + ": " + validNumber.isNumber(s));
        }
    }

}
