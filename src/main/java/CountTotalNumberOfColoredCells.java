
public class CountTotalNumberOfColoredCells {

    public long coloredCells(int n) {
        return n == 1 ? 1 : (n - 1) * 4L + coloredCells(n - 1);
    }

}
