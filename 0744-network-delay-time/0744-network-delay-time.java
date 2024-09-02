import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> edges = new HashMap<>();

        for(int[] time: times){
            int key = time[0];
            if(!edges.containsKey(key)){
                edges.put(key, new ArrayList<>());
            }
            edges.get(key).add(time);
        }
        return dijkstra(edges, n, k);
    }

    private int dijkstra(Map<Integer, List<int[]>> edges, int n, int k){
        int[] vis = new int[n + 1];
        Arrays.fill(vis, Integer.MAX_VALUE);
        Queue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
        pq.add(new int[] {k,0});
        vis[k] = 0;

        int maxTime =0;
        int visitCount = 1;
        while(!pq.isEmpty()){
            int[] cur = pq.remove();
            int u = cur[0];
            int time = cur[1];
            if(vis[u] < time) continue;
            maxTime = time;

            if(!edges.containsKey(u)) continue;
            for(int[] edge : edges.get(u)){
                int v= edge[1];
                int w = edge[2];

                if(time + w >= vis[v]) continue;
                if(vis[v] == Integer.MAX_VALUE) visitCount++;

                vis[v] = time + w;
                pq.add(new int[] {v, time+ w});
            }
        }
        return visitCount == n ? maxTime:-1;
    }
}