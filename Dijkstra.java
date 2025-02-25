import java.util.*;

public class Dijkstra {
    public static void dijkstra(int V, int[][] graph, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0], d = current[1];

            if (d > dist[u]) continue;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }

        for (int i = 0; i < V; i++) {
            System.out.println("Distance from " + src + " to " + i + ": " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] graph = {
            {0, 10, 0, 30, 100},
            {10, 0, 50, 0, 0},
            {0, 50, 0, 20, 10},
            {30, 0, 20, 0, 60},
            {100, 0, 10, 60, 0}
        };
        dijkstra(V, graph, 0);
    }
}
