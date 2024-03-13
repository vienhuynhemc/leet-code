public class FindThePivotInteger {

    public int pivotInteger(int n) {
        if (n == 1) {
            return n;
        }

        int left = 1;
        int sumFromLeft = 1;

        int right = n;
        int sumFromRight = n;

        while (left < right) {
            if (sumFromLeft < sumFromRight) {
                sumFromLeft += ++left;
            } else {
                sumFromRight += --right;
            }

            if (sumFromLeft == sumFromRight && left + 1 == right - 1) {
                return left + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FindThePivotInteger handler = new FindThePivotInteger();
        System.out.println(handler.pivotInteger(8));
    }

}
