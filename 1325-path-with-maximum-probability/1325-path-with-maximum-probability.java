class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // 다익스트라 min(cost + cost) => max(prob * prob)

        // 초기설정
        Map<Integer, List<Edge>> graph = new HashMap<>();
        double[] probs = new double[n+1];
        Arrays.fill(probs, 0.0);

        for(int i=0; i<n; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int i = 0; i < edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double w = succProb[i];
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }

        // 다익스트라 진행
        // 시작점 예약
        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start_node, 1.0));
        probs[start_node] = 1.0;

        // while( pq)
        while(!pq.isEmpty()){
            //    방문
            Edge cur = pq.remove();
            if(probs[cur.node] > cur.cost) continue;
            //  예약
            for(Edge next: graph.get(cur.node)){
                double nextCost = probs[cur.node] * next.cost;
                if(nextCost > probs[next.node]){
                    pq.add(new Edge(next.node, nextCost));
                    probs[next.node] = nextCost;
                }
            }
        }

        return probs[end_node];        
    }
}
class Edge implements Comparable<Edge> {
    int node;
    double cost;

      public Edge(int node, double cost){
    this.node = node;
    this.cost = cost;
  }

  @Override
  public int compareTo(Edge o) {
    if(this.cost - o.cost > 0){
      return -1;
    }
    else
      return 1;
  }
}