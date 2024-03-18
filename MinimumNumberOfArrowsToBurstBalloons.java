import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons {

    public int findMinArrowShots(int[][] points) {
        this.sortPointsAccordingTheEnd(points);

        int length = points.length;

        int arrows = 1;
        int limitBalloonEnd = points[0][1];

        for (int i = 1; i < length; i++) {
            if (points[i][0] > limitBalloonEnd) {
                limitBalloonEnd = points[i][1];
                arrows++;
            }
        }

        return arrows;
    }

    private void sortPointsAccordingTheEnd(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
    }

    public static void main(String[] args) {
        MinimumNumberOfArrowsToBurstBalloons handler = new MinimumNumberOfArrowsToBurstBalloons();
        System.out.println(handler.findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
    }

}