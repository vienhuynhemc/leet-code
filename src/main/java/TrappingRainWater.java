
public class TrappingRainWater {

    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }

        int[][] zones = new int[2][height.length - 2];
        int maxOfLeft = height[0];

        for (int i = 1; i < height.length - 1; i++) {
            zones[0][i - 1] = maxOfLeft;
            if (height[i] > maxOfLeft) {
                maxOfLeft = height[i];
            }
        }

        int maxOfRight = height[height.length - 1];
        for (int i = height.length - 2; i > 0; i--) {
            zones[1][i - 1] = maxOfRight;
            if (height[i] > maxOfRight) {
                maxOfRight = height[i];
            }
        }

        int totalTrapperRainWater = 0;
        for (int i = 0; i < zones[0].length; i++) {
            int trapperRainWaterOfCol = Math.min(zones[1][i], zones[0][i]) - height[i + 1];
            totalTrapperRainWater += Math.max(trapperRainWaterOfCol, 0);
        }

        return totalTrapperRainWater;
    }

    public static void main(String[] args) {
        TrappingRainWater handler = new TrappingRainWater();
        System.out.println(handler.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

}
