/* vienhuynhemc */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FindAllPossibleRecipesFromGivenSupplies {

  public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
    final Map<String, List<String>> degrees = new HashMap<>();
    final Map<String, Integer> indegrees = new HashMap<>();
    final Set<String> recipeIdentities = new HashSet<>(Arrays.asList(recipes));

    for (int i = 0; i < recipes.length; i++) {
      final String recipe = recipes[i];
      final List<String> ingredient = ingredients.get(i);

      indegrees.putIfAbsent(recipe, 0);
      indegrees.put(recipe, indegrees.get(recipe) + ingredient.size());

      for (String s : ingredient) degrees.computeIfAbsent(s, _ -> new ArrayList<>()).add(recipe);
    }

    final Queue<String> processingQueue = new LinkedList<>();
    for (String supply : supplies) processingQueue.offer(supply);

    final List<String> result = new ArrayList<>();
    while (!processingQueue.isEmpty()) {
      final String supply = processingQueue.poll();
      if (recipeIdentities.contains(supply)) result.add(supply);
      if (!degrees.containsKey(supply)) continue;

      for (String s : degrees.get(supply)) {
        indegrees.put(s, indegrees.get(s) - 1);
        if (indegrees.get(s) == 0) {
          processingQueue.offer(s);
          indegrees.remove(s);
        }
      }
      degrees.remove(supply);
    }

    return result;
  }

  static void main() {
    final var test = new FindAllPossibleRecipesFromGivenSupplies();
    System.out.println(
      test.findAllRecipes(
        new String[] { "bread", "sandwich", "burger" },
        List.of(List.of("yeast", "flour"), List.of("bread", "meat"), List.of("sandwich", "meat", "bread")),
        new String[] { "yeast", "flour", "meat" }
      )
    );
  }
}
