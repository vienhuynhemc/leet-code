
public class CheckIfNumberIsASumOfPowersOfThree {

    public boolean checkPowersOfThree(int n) {
        int i = 15;

        while (i > -1) {
            if (checkPowersOfThree(n, 0, i)) {
                return true;
            }
            i--;
        }

        return false;
    }


    private boolean checkPowersOfThree(int n, int value, int exponent) {
        int currentValue = (int) Math.pow(3, exponent);
        int sum = currentValue + value;
        if (sum == n) {
            return true;
        }

        if (sum > n) {
            return false;
        }

        int i = exponent - 1;
        while (i > -1) {
            if (checkPowersOfThree(n, sum, i)) {
                return true;
            }
            i--;
        }

        return false;
    }

}
