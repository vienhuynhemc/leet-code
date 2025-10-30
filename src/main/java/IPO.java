/* vienhuynhemc */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class IPO {

  public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
    final List<Project> projects = new ArrayList<>();
    for (int i = 0; i < profits.length; i++) {
      projects.add(new Project(profits[i], capital[i]));
    }
    projects.sort(Comparator.comparingInt(o -> o.capital));

    final PriorityQueue<Integer> data = new PriorityQueue<>((x, y) -> y - x);

    int j = 0;
    for (int i = 0; i < k; i++) {
      while (j < capital.length && projects.get(j).capital <= w) {
        data.add(projects.get(j).profit);
        j++;
      }

      if (data.isEmpty()) {
        break;
      }

      w += data.poll();
    }

    return w;
  }

  private static final class Project {

    final int profit;
    final int capital;

    public Project(int profit, int capital) {
      this.profit = profit;
      this.capital = capital;
    }
  }
}
