
import java.util.*;

class Solution {
  static boolean[][] visited;
  static char[][] grid;
  static int[] dr = { 0, 1, 0, -1 };
  static int[] dc = { 1, 0, -1, 0 };
  static int rowLength;
  static int colLength;

  public static boolean isValid(int r, int c) {
    return (r >= 0 && r < rowLength) && (c >= 0 && c < colLength) && (grid[r][c] == '1');
  }

  public static void dfs(int r, int c) {
    Deque<int []> stack = new ArrayDeque<>();
    stack.push(new int[] { r, c });
    visited[r][c] = true;

    while (!stack.isEmpty()) {
      int[] cur = stack.pop();
      int curRow = cur[0];
      int curCol = cur[1];

      for (int i = 0; i < 4; i++) {
        int nextRow = curRow + dr[i];
        int nextCol = curCol + dc[i];
        if (isValid(nextRow, nextCol)) {
          if (!visited[nextRow][nextCol]) {
            stack.push(new int[] { nextRow, nextCol });
            visited[nextRow][nextCol] = true;
          }
        }
      }
    }
  }

  public int numIslands(char[][] grid) {
    this.grid = grid;
    rowLength = grid.length;
    colLength = grid[0].length;
    visited = new boolean[rowLength][colLength];
    int count = 0;

    for (int i = 0; i < rowLength; i++) {
      for (int j = 0; j < colLength; j++) {
        if (!visited[i][j] && grid[i][j] == '1') {
          dfs(i, j);
          count++;
        }
      }
    }
    return count;
  }
}