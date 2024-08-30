import java.util.*;

class Solution {

  public int networkDelayTime(int[][] times, int n, int k) {
    // 그래프 초기화
    Map<Integer, List<Edge>> edges = new HashMap<>();
    for (int[] time : times) {
      int key = time[0];
      if (!edges.containsKey(key)) {
        edges.put(key, new ArrayList<>());
      }
      edges.get(key).add(new Edge(time[1], time[2]));
    }

    // 다익스트라 알고리즘 실행
    return dijkstra(edges, k, n);
  }

  private int dijkstra(Map<Integer, List<Edge>> graph, int start, int size) {
    final int INF = Integer.MAX_VALUE;
    int[] distance = new int[size + 1];
    Arrays.fill(distance, INF);

    // 최소 힙 구현
    Queue<Edge> pq = new PriorityQueue<>();
    pq.add(new Edge(start, 0)); // 시작점 노드와 거리 cost를 설정

    distance[start] = 0;

    while (!pq.isEmpty()) {
      // 방문
      Edge cur = pq.remove();
      if (distance[cur.to] < cur.cost) {
        continue;
      }
      // 다음 노드 처리
      if (graph.containsKey(cur.to)) {
        for (Edge next : graph.get(cur.to)) {
          int nextCost = distance[cur.to] + next.cost;
          if (nextCost < distance[next.to]) {
            pq.add(new Edge(next.to, nextCost));
            distance[next.to] = nextCost;
          }
        }
      }
    }

    int max = 0;
    for (int i = 1; i <= size; i++) {
      if (distance[i] == INF) return -1;
      if (max < distance[i]) {
        max = distance[i];
      }
    }
    return max;
  }

  class Edge implements Comparable<Edge> {
    public int to;
    public int cost;

    public Edge(int to, int cost) {
      this.to = to;
      this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
      return this.cost - o.cost; // 오름차순 정렬
    }
  }
}