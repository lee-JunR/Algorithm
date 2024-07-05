class Solution {

  public static boolean isValid(String s) {
    Deque<Character> deq = new LinkedList<>();
    HashMap<Character, Character> map = new HashMap<>();
    map.put('(', ')');
    map.put('[', ']');
    map.put('{', '}');

    char[] w = s.toCharArray();

    for (int i = 0; i < w.length; i++) {
      if (w[i] == '(' || w[i] == '[' || w[i] == '{') {
        deq.offerLast(w[i]);
        System.out.println(deq.peekLast());
      } else{
        if (deq.isEmpty()) {
          return false;
        }
        if (map.get(deq.peekLast()) != w[i]) {
          return false;
        }
        deq.pollLast();
      }
    }

    return deq.isEmpty();
  }



}