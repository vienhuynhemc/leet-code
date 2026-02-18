/* vienhuynhemc */
import helper.LoadArray;
import helper.LogTimeExecute;

public class JumpGame {

  public boolean canJump(int[] nums) {
    final boolean[] canJumpToEnd = new boolean[nums.length];
    canJumpToEnd[nums.length - 1] = true;

    int index = nums.length - 1;
    while (index-- > 0) {
      for (int i = nums[index]; i >= 1; i--) {
        final int newIndex = index + i;
        if (newIndex <= nums.length - 1 && canJumpToEnd[newIndex]) {
          canJumpToEnd[index] = true;
          break;
        }
      }
    }

    return canJumpToEnd[0];
  }

  static void main() {
    JumpGame jumpGame = new JumpGame();
    System.out.println(jumpGame.canJump(new int[] { 2, 3, 1, 1, 4 }));
    System.out.println(jumpGame.canJump(new int[] { 3, 2, 1, 0, 4 }));
    int[] largeArray = LoadArray.getInstance().loadIntArrayFromFile("src/main/resources/test-data/jump-game.txt");
    LogTimeExecute.getInstance().log(unused -> jumpGame.canJump(largeArray));
  }
}
