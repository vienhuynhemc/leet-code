/* vienhuynhemc */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class FindAllPeopleWithSecret {

  private record Pair(int first, int second) {}

  public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
    final Map<Integer, List<Pair>> personToMeetPersons = new HashMap<>();
    for (int[] meeting : meetings) {
      personToMeetPersons.computeIfAbsent(meeting[0], _ -> new ArrayList<>()).add(new Pair(meeting[1], meeting[2]));
      personToMeetPersons.computeIfAbsent(meeting[1], _ -> new ArrayList<>()).add(new Pair(meeting[0], meeting[2]));
    }

    final int[] timesKnowSecret = new int[n];
    Arrays.fill(timesKnowSecret, Integer.MAX_VALUE);
    timesKnowSecret[0] = 0;
    timesKnowSecret[firstPerson] = 0;

    final Queue<Pair> queue = new LinkedList<>();
    queue.add(new Pair(0, 0));
    queue.add(new Pair(firstPerson, 0));

    while (!queue.isEmpty()) {
      final Pair pair = queue.poll();
      if (pair.second > timesKnowSecret[pair.first]) {
        continue;
      }

      for (Pair next : personToMeetPersons.getOrDefault(pair.first, new ArrayList<>())) {
        if (next.second >= timesKnowSecret[pair.first] && next.second < timesKnowSecret[next.first]) {
          timesKnowSecret[next.first] = next.second;
          queue.add(next);
        }
      }
    }

    final List<Integer> result = new ArrayList<>();
    for (int i = 0; i < timesKnowSecret.length; i++) {
      if (timesKnowSecret[i] != Integer.MAX_VALUE) {
        result.add(i);
      }
    }

    return result;
  }
}
