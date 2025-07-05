package src.main.java;

import src.main.java.helper.LoadArray;
import src.main.java.helper.LogTimeExecute;

import java.util.HashSet;
import java.util.Set;

public class JumpGame {

    private final Set<Integer> tracking;

    public JumpGame() {
        this.tracking = new HashSet<>();
    }

    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        this.tracking.clear();
        return jump(0, nums);
    }

    private boolean jump(int index, int[] nums) {
        if (index == nums.length - 1) {
            return true;
        }
        if (this.tracking.contains(index)) {
            return false;
        }
        if (index >= nums.length || nums[index] == 0) {
            this.tracking.add(index);
            return false;
        }
        for (int i = nums[index]; i > 0; i--) {
            boolean canJump = jump(index + i, nums);
            if (canJump) {
                return true;
            }
        }
        this.tracking.add(index);
        return false;
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jumpGame.canJump(new int[]{3, 2, 1, 0, 4}));
        int[] largeArray = LoadArray.getInstance().loadIntArrayFromFile("resource/test-data/jump-game.txt");
        LogTimeExecute.getInstance().log(unused -> jumpGame.canJump(largeArray));
    }

}
