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
    backtrack(new ArrayList<Integer>(), 0);
    return result;
  }

  private static void backtrack(List<Integer> cur, int i) {
    if (cur.size() == lengthOfArr) {
      result.add(new ArrayList<>(cur));
      return;
    }

    for (int j = 0; j < lengthOfArr; j++) {
      if(cur.contains(nums[j])){
        continue;
      }
      cur.add(nums[j]);
      backtrack(cur, i+1);
      cur.remove(cur.size()-1);
    }

  }
}