class Solution {

  static List<List<Integer>> result;
  static int lengthOfArr;

  public List<List<Integer>> permute(int[] nums) {
    lengthOfArr = nums.length;
    result = new ArrayList<>();
    boolean[] visited = new boolean[lengthOfArr];
    backtrack(new ArrayList<Integer>(), nums,visited);
    return result;
  }

  private static void backtrack(List<Integer> cur, int[] arr, boolean[] visited) {
    if (cur.size() == lengthOfArr) {
      result.add(new ArrayList<>(cur));
      return;
    }
    for (int i = 0; i < lengthOfArr; i++) {
      if(visited[i]) continue;

      cur.add(arr[i]);
      visited[i] = true;
      backtrack(cur, arr, visited);
      cur.remove(cur.size()-1);
      visited[i] = false;
    }
  }
}