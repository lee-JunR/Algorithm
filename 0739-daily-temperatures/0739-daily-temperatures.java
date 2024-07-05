class Solution {
  public int[] dailyTemperatures(int[] temperatures) {
    Deque<Integer> stack = new LinkedList<>();
    int[] result = new int[temperatures.length];
    for (int i = 0 ; i < temperatures.length ; i++) {
      while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
        result[stack.peek()] = i - stack.peek();
        stack.pop();
      }
      stack.push(i); // 스택의 의 peek가 
    }

    return result;
  }
}