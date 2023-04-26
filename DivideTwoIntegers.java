import load.LogTimeExecute;

public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        int sign = dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0 ? 1 : -1;
        long divisorLong = divisor;
        double dividendDouble = Math.abs((long) dividend);
        divisorLong = Math.abs(divisorLong);
        long result = 0;
        long storage = divisorLong;
        long step = 1;
        while (dividendDouble >= divisorLong) {
            dividendDouble -= storage;
            storage += divisorLong;
            result += step;
            step++;
            if (dividendDouble - storage < 0) {
                storage = divisorLong;
                step = 1;
            }
        }
        result = sign == 1 ? result : -result;
        if (result > Math.pow(2, 31) - 1) {
            result = (long) (Math.pow(2, 31) - 1);
        }
        if (result < -Math.pow(2, 31)) {
            result = (long) -Math.pow(2, 31);
        }
        return (int) result;
    }

    public static void main(String[] args) {
        DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();
        System.out.println(divideTwoIntegers.divide(10, 3));
        System.out.println(divideTwoIntegers.divide(7, -3));
        LogTimeExecute.getInstance().log(unused -> divideTwoIntegers.divide(-2147483648, -1));
        System.out.println(divideTwoIntegers.divide(1, 1));
        System.out.println(divideTwoIntegers.divide(2147483647, 1));
        LogTimeExecute.getInstance().log(unused -> divideTwoIntegers.divide(-2147483648, -3));
        LogTimeExecute.getInstance().log(unused -> divideTwoIntegers.divide(1004958205, -2137325331));
        System.out.println(divideTwoIntegers.divide(-2147483648, -1));
    }

}
