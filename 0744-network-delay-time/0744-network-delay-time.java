import java.util.*;

class Solution {
    // 내부 클래스 정의
    private static class Edge {
        int target;
        int weight;

        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        // 그래프를 인접 리스트로 표현
        Map<Integer, List<Edge>> edges = new HashMap<>();

        // 그래프 초기화
        for (int[] time : times) {
            int source = time[0];
            int target = time[1];
            int weight = time[2];
            edges.computeIfAbsent(source, key -> new ArrayList<>()).add(new Edge(target, weight));
        }

        // 다익스트라 알고리즘 실행
        return dijkstra(edges, n, k);
    }

    private int dijkstra(Map<Integer, List<Edge>> edges, int n, int k) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] {k, 0});
        dist[k] = 0;

        int maxTime = 0;
        int visitCount = 1;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            int time = cur[1];

            if (dist[u] < time) continue;
            maxTime = time;

            List<Edge> neighbors = edges.get(u);
            if (neighbors == null) continue;

            for (Edge edge : neighbors) {
                int v = edge.target;
                int w = edge.weight;

                if (time + w >= dist[v]) continue;
                if (dist[v] == Integer.MAX_VALUE) visitCount++;

                dist[v] = time + w;
                pq.add(new int[] {v, dist[v]});
            }
        }

        return visitCount == n ? maxTime : -1;
    }
}