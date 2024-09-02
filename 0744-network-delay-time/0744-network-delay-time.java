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
        int[] vis = new int[n + 1];
        Arrays.fill(vis, Integer.MAX_VALUE);
        Queue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
        pq.add(new int[] {k, 0});
        vis[k] = 0;

        int maxTime = 0;
        int visitCount = 1;

        while (!pq.isEmpty()) {
            int[] cur = pq.remove();
            int u = cur[0];
            int time = cur[1];

            if (vis[u] < time) continue;
            maxTime = time;

            List<Edge> neighbors = edges.get(u);
            if (neighbors == null) continue;

            for (Edge edge : neighbors) {
                int v = edge.target;
                int w = edge.weight;

                if (time + w >= vis[v]) continue;
                if (vis[v] == Integer.MAX_VALUE) visitCount++;

                vis[v] = time + w;
                pq.add(new int[] {v, time + w});
            }
        }

        return visitCount == n ? maxTime : -1;
    }
}