
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DesignGraphWithShortestPathCalculator {

    static class Graph {

        private final Map<Integer, List<Node>> edges = new HashMap<>();

        public Graph(int n, int[][] edges) {
            for (int i = 0; i < n; i++) {
                this.edges.put(i, new ArrayList<>());
            }

            for (int[] edge : edges) {
                List<Node> nodes = this.edges.get(edge[0]);
                nodes.add(new Node(edge[1], edge[2]));
            }
        }

        public void addEdge(int[] edge) {
            List<Node> nodes = this.edges.get(edge[0]);
            nodes.add(new Node(edge[1], edge[2]));
        }

        public int shortestPath(int node1, int node2) {
            if (node1 == node2) {
                return 0;
            }

            List<Node> nodes = edges.get(node1);
            if (nodes.isEmpty()) {
                return -1;
            }


            Map<Integer, Integer> readyNodes = new HashMap<>();
            Set<Integer> seenNodes = new HashSet<>();
            seenNodes.add(node1);
            nodes.forEach(node -> readyNodes.put(node.getName(), node.getGap()));
            dijkstra(readyNodes, node2, seenNodes);

            Integer result = readyNodes.get(node2);
            return result == null ? -1 : result;
        }

        private void dijkstra(Map<Integer, Integer> readyNodes, int target, Set<Integer> seenNodes) {
            if (readyNodes.isEmpty()) {
                return;
            }
            int minNode = -1;
            int minGap = -1;
            for (Map.Entry<Integer, Integer> entry : readyNodes.entrySet()) {
                if (minGap == -1) {
                    minGap = entry.getValue();
                    minNode = entry.getKey();
                    continue;
                }

                if (entry.getValue() < minGap) {
                    minGap = entry.getValue();
                    minNode = entry.getKey();
                }
            }

            if (minNode == target) {
                return;
            }
            readyNodes.remove(minNode);
            seenNodes.add(minNode);

            List<Node> nodes = edges.get(minNode);
            for (Node node : nodes) {
                if (seenNodes.contains(node.getName())) {
                    continue;
                }
                Integer gap = readyNodes.get(node.getName());
                int newGap = node.gap + minGap;
                if (gap == null || gap > newGap) {
                    readyNodes.put(node.getName(), newGap);
                }
            }

            dijkstra(readyNodes, target, seenNodes);
        }

        private class Node {
            private final int name;
            private final int gap;

            public Node(int name, int gap) {
                this.name = name;
                this.gap = gap;
            }

            public int getName() {
                return name;
            }

            public int getGap() {
                return gap;
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4, new int[][]{});
        graph.addEdge(new int[]{0, 3, 745857});
        graph.addEdge(new int[]{1, 3, 432074});
        graph.addEdge(new int[]{0, 2, 103840});
        graph.addEdge(new int[]{2, 0, 100674});
        graph.addEdge(new int[]{1, 2, 977334});
        System.out.println(graph.shortestPath(2, 1));
    }

}
