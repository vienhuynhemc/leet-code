
import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        for (int visitNode : graph[0]) {
            List<Integer> paths = new ArrayList<>();
            paths.add(0);
            this.findPath(graph.length - 1, visitNode, graph, paths, result);
        }
        return result;
    }

    private void findPath(int target, int currentNode, int[][] graph, List<Integer> paths, List<List<Integer>> allPaths) {
        paths.add(currentNode);
        if (currentNode == target)
            allPaths.add(paths);
        else
            for (int visitNode : graph[currentNode])
                this.findPath(target, visitNode, graph, new ArrayList<>(paths), allPaths);

    }

    public static void main(String[] args) {
        AllPathsFromSourceToTarget allPathsFromSourceToTarget = new AllPathsFromSourceToTarget();
        System.out.println(allPathsFromSourceToTarget.allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}}));
        System.out.println(allPathsFromSourceToTarget.allPathsSourceTarget(new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}}));
    }

}
