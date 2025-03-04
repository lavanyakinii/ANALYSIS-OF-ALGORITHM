import java.util.*;

public class Kruskal {

    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.weight - edge.weight;
        }
    }

    static class DisjointSet {
        int[] parent, rank;

        public DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }

    static void kruskal(int[][] graph) {
        int V = graph.length;
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                if (graph[i][j] != 0) {
                    edges.add(new Edge(i, j, graph[i][j]));
                }
            }
        }

        Collections.sort(edges);

        DisjointSet ds = new DisjointSet(V);
        List<Edge> mst = new ArrayList<>();

        for (Edge edge : edges) {
            int x = ds.find(edge.src);
            int y = ds.find(edge.dest);

            if (x != y) {
                mst.add(edge);
                ds.union(x, y);
            }
        }

        System.out.println("Edge \tWeight");
        for (Edge edge : mst) {
            System.out.println(edge.src + " - " + edge.dest + " \t" + edge.weight);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                { 0, 10, 0, 30 },
                { 10, 0, 50, 40 },
                { 0, 50, 0, 20 },
                { 30, 40, 20, 0 }
        };

        kruskal(graph);
    }
}