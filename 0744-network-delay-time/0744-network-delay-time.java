import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 그래프를 인접 리스트로 표현
        Map<Integer, List<int[]>> edges = new HashMap<>();

        // 그래프 초기화
        for (int[] time : times) {
            edges.computeIfAbsent(time[0], key -> new ArrayList<>()).add(new int[] {time[1], time[2]});
        }

        // 다익스트라 알고리즘 실행
        return dijkstra(edges, n, k);
    }

    private int dijkstra(Map<Integer, List<int[]>> edges, int n, int k) {
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

            // 이 노드가 연결된 간선이 없다면 continue 없이 다음으로 넘어감
            List<int[]> neighbors = edges.get(u);
            if (neighbors == null) continue;

            for (int[] edge : neighbors) {
                int v = edge[0];
                int w = edge[1];

                if (time + w >= vis[v]) continue;
                if (vis[v] == Integer.MAX_VALUE) visitCount++;

                vis[v] = time + w;
                pq.add(new int[] {v, time + w});
            }
        }

        return visitCount == n ? maxTime : -1;
    }
}