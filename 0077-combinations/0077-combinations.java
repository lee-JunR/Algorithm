import java.util.ArrayList;
import java.util.List;

class Solution {

  static List<List<Integer>> result;
  static int n;
  static int k;

  public List<List<Integer>> combine(int n, int k) {
    result = new ArrayList<>();
    this.n = n;
    this.k = k;
    backtrack(1, new ArrayList<>());
    return result;
  }


  private static void backtrack(int start, List<Integer> cur) {
    if (cur.size() == k) {
      result.add(new ArrayList<>(cur));
      return;
    }
    for (int i = start; i <= n; i++) {
      cur.add(i);
      backtrack(i + 1, cur);
      cur.remove(cur.size() - 1);
    }
  }

}