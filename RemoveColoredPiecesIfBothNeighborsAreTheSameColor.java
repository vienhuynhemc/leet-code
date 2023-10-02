public class RemoveColoredPiecesIfBothNeighborsAreTheSameColor {

    public boolean winnerOfGame(String colors) {
        int numberOfAMove = 0;
        int numberOfBMove = 0;

        int n = colors.length();
        boolean isAStart = colors.charAt(0) == 'A';
        int count = 1;
        for (int i = 1; i < n; i++) {
            boolean isA = colors.charAt(i) == 'A';

            if (isAStart) {
                if (isA) {
                    count++;
                } else {
                    numberOfAMove += count < 3 ? 0 : count - 2;
                    count = 1;
                    isAStart = false;
                }
            } else {
                if (isA) {
                    numberOfBMove += count < 3 ? 0 : count - 2;
                    count = 1;
                    isAStart = true;
                } else {
                    count++;
                }
            }
        }

        if (count > 2) {
            if (isAStart) {
                numberOfAMove += count - 2;
            } else {
                numberOfBMove += count - 2;
            }
        }

        return numberOfAMove - 1 >= numberOfBMove;
    }

    public static void main(String[] args) {
        var handler = new RemoveColoredPiecesIfBothNeighborsAreTheSameColor();
        System.out.println(handler.winnerOfGame("AAAABBBB"));
    }

}
