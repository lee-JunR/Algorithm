import java.util.*;

class Solution {

  static boolean[][] visited;
  static int[][] grid;
  static int[] dr = {0, 1, 0, -1, 1, 1, -1, -1};
  static int[] dc = {1, 0, -1, 0, 1, -1, 1, -1};
  static int rowLength;
  static int colLength;

  public static boolean isValid(int r, int c) {
    return (r >= 0 && r < rowLength) && (c >= 0 && c < colLength) && (grid[r][c] == 0) && (!visited[r][c]);
  }

  public static int bfs(int r, int c) {
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{r, c, 1});
    visited[r][c] = true;

    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int curRow = cur[0];
      int curCol = cur[1];
      int count = cur[2];

      if ((rowLength - 1 == curRow) && (colLength - 1 == curCol)) {
        return count;
      }

      for (int i = 0; i < 8; i++) {
        int nextRow = curRow + dr[i];
        int nextCol = curCol + dc[i];

        if (isValid(nextRow, nextCol)) {
          queue.offer(new int[]{nextRow, nextCol, count + 1});
          visited[nextRow][nextCol] = true;
        }
      }
    }
    return -1;
  }

  public int shortestPathBinaryMatrix(int[][] grid) {
    this.grid = grid;
    rowLength = colLength = grid.length;
    visited = new boolean[rowLength][colLength];

    if (grid[0][0] == 1 || grid[rowLength - 1][colLength - 1] == 1) {
      return -1;
    }

    return bfs(0, 0);
  }
}
