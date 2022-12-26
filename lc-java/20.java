import java.util.Stack;

class Solution {
  public boolean isValid(String s) {
    char[] c = s.toCharArray();
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < c.length; i++) {
      if (c[i] == '(' || c[i] == '[' || c[i] == '{') {
        stack.push(c[i]);
      } else {
        if (stack.empty()) {
          return false;
        }
        if (c[i] == ')') {
          if (stack.peek() == '(') {
            stack.pop();
          } else {
            return false;
          }
        } else if (c[i] == ']') {
          if (stack.peek() == '[') {
            stack.pop();
          } else {
            return false;
          }
        } else {
          if (stack.peek() == '{') {
            stack.pop();
          } else {
            return false;
          }
        }
      }
    }
    if (!stack.empty()) {
      return false;
    }
    return true;
  }
}