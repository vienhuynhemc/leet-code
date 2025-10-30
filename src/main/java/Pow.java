
import src.main.java.helper.LogTimeExecute;

public class Pow {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        final int sign = n < 0 ? -1 : 1;
        n = Math.abs(n);
        double value = x;
        int step = 1;
        n -= 1;
        double storage = x;
        while (n > 0) {
            value *= storage;
            n -= step;
            storage *= x;
            step++;
            if (n < step) {
                step = 1;
                storage = x;
            }
        }
        return sign == -1 ? 1 / value : value;
    }

    public static void main(String[] args) {
        Pow pow = new Pow();
        System.out.println(pow.myPow(2, 10));
        System.out.println(pow.myPow(2.1, 3));
        System.out.println(pow.myPow(2, -2));
        LogTimeExecute.getInstance().log(unused -> pow.myPow(1, 2147483647));
    }

}
