import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 그래프를 인접 리스트로 표현
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.computeIfAbsent(time[0], key -> new ArrayList<>()).add(new int[] {time[1], time[2]});
        }
        return dijkstra(graph, n, k);
    }

    private int dijkstra(Map<Integer, List<int[]>> graph, int n, int k){
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // 최소 우선순위 큐를 사용해 가장 작은 거리를 가진 노드를 처리
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] {k, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];
            int currentDist = current[1];

            if (currentDist > dist[u]) continue;

            if (graph.containsKey(u)) {
                for (int[] neighbor : graph.get(u)) {
                    int v = neighbor[0];
                    int time = neighbor[1];

                    // 더 짧은 경로를 찾은 경우 업데이트
                    if (dist[u] + time < dist[v]) {
                        dist[v] = dist[u] + time;
                        pq.add(new int[] {v, dist[v]});
                    }
                }
            }
        }

        // 모든 노드에 도달할 수 있는지 확인하고, 최대 시간을 계산
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}