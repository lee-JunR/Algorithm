import java.util.ArrayList;
import java.util.List;

class Solution {

  static List<List<Integer>> result;
  static int lengthOfArr;
  static int[] nums;

  public List<List<Integer>> permute(int[] nums) {
    lengthOfArr = nums.length;
    result = new ArrayList<>();
    this.nums = nums;
    boolean[] visited = new boolean[lengthOfArr];
    backtrack(new ArrayList<Integer>(),visited);
    return result;
  }

  private static void backtrack(List<Integer> cur, boolean[] visited) {
    if (cur.size() == lengthOfArr) {
      result.add(new ArrayList<>(cur));
      return;
    }
    for (int i = 0; i < lengthOfArr; i++) {
      if(visited[i]) continue;

      cur.add(nums[i]);
      visited[i] = true;
      backtrack(cur, visited);
      cur.remove(cur.size()-1);
      visited[i] = false;
    }
  }
}