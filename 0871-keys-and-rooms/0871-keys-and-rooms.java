import java.util.*;

class Solution {
  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    int n = rooms.size();
    boolean[] visited = new boolean[n];

    // 0번 방부터 시작
    backtrack(rooms, visited, 0);

    // 모든 방이 방문되었는지 확인
    for (boolean visit : visited) {
      if (!visit) {
        return false;
      }
    }
    return true;
  }

  private void backtrack(List<List<Integer>> rooms, boolean[] visited, int cur) {
    // 현재 방을 방문한 것으로 표시
    visited[cur] = true;

    // 현재 방의 모든 열쇠에 대해 백트래킹
    for (int next : rooms.get(cur)) {
      if (!visited[next]) {
        backtrack(rooms, visited, next);
      }
    }
  }
}