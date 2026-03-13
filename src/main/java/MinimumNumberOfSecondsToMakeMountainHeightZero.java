/* vienhuynhemc */
public class MinimumNumberOfSecondsToMakeMountainHeightZero {

  public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
    long left = 0;
    long right = countWorstCase(mountainHeight, workerTimes);
    long result = right;

    while (left <= right) {
      final long mid = left + (right - left) / 2;

      final boolean canMakeMountainHeightZero = canMakeMountainHeightZero(mountainHeight, workerTimes, mid);

      if (canMakeMountainHeightZero) {
        result = mid;
        right = mid - 1;
      } else left = mid + 1;
    }

    return result;
  }

  private long countWorstCase(int mountainHeight, int[] workerTimes) {
    int maxWorkerTime = 0;
    for (int workerTime : workerTimes) maxWorkerTime = Math.max(maxWorkerTime, workerTime);

    long time = 0;
    int rate = 1;
    while (mountainHeight-- > 0) time += (long) maxWorkerTime * rate++;

    return time;
  }

  private boolean canMakeMountainHeightZero(int mountainHeight, int[] workerTimes, long estimateTime) {
    int reduceHeight = 0;

    for (int workerTime : workerTimes) {
      reduceHeight += calculateReducingHeight(workerTime, estimateTime);
      if (reduceHeight >= mountainHeight) return true;
    }

    return false;
  }

  private int calculateReducingHeight(int workingTime, long estimateTime) {
    int rate = 1;
    while (estimateTime > 0) estimateTime -= (long) workingTime * rate++;

    return estimateTime < 0 ? rate - 2 : rate - 1;
  }
}
