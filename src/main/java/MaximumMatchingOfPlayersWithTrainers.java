package src.main.java;

import java.util.Arrays;

public class MaximumMatchingOfPlayersWithTrainers {

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int result = 0;

        int i = 0;
        int j = 0;
        while (i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) {
                result++;
                i++;
            }

            j++;
        }

        return result;
    }

}
