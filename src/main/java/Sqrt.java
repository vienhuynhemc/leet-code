
public class Sqrt {

    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            long calcValue = (long) mid * mid;
            if (calcValue == x) {
                return mid;
            }

            if (calcValue > x) {
                right = mid - 1;
                continue;
            }

            ans = mid;
            left = mid + 1;
        }

        return ans;
    }


    public static void main(String[] args) {
        final Sqrt test = new Sqrt();
        System.out.println(test.mySqrt(1));
        System.out.println(test.mySqrt(2));
        System.out.println(test.mySqrt(3));
        System.out.println(test.mySqrt(4));
        System.out.println(test.mySqrt(5));
        System.out.println(test.mySqrt(6));
        System.out.println(test.mySqrt(7));
        System.out.println(test.mySqrt(8));
        System.out.println(test.mySqrt(9));
        System.out.println(test.mySqrt(10));
        System.out.println(test.mySqrt(2147483647));
    }

}
