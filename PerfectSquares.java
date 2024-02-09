public class PerfectSquares {

    public int numSquares(int n) {
        if (isSquare(n)) {
            return 1;
        }

        for (int i = 1; i <= (int) Math.sqrt(n) + 1; i++) {
            if (isSquare(n - (i * i))) {
                return 2;
            }
        }

        while (n % 4 == 0) {
            n >>= 2;
        }
        if (n % 8 == 7) {
            return 4;
        }

        return 3;
    }

    private boolean isSquare(int x) {
        int sqRoot = (int) Math.sqrt(x);
        return (sqRoot * sqRoot == x);
    }

    public static void main(String[] args) {
        PerfectSquares handler = new PerfectSquares();
        System.out.println(handler.numSquares(5756));
    }

}
