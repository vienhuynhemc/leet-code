public class WaterBottlesII {

    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int drinkBottles = 0;
        int emptyBottles = 0;

        do {
            drinkBottles += numBottles;
            emptyBottles += numBottles;
            numBottles = 0;

            while (emptyBottles >= numExchange) {
                numBottles++;
                emptyBottles -= numExchange++;
            }
        } while (numBottles != 0);

        return drinkBottles;
    }

    public static void main(String[] args) {
        var handler = new WaterBottlesII();
        System.out.println(handler.maxBottlesDrunk(10, 3));
    }
}
