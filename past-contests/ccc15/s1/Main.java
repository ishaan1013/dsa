import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int total = 0;
    Stack<Integer> stk = new Stack<>();
    for (int i = 0; i < n; i++) {
      int x = Integer.parseInt(br.readLine());
      if (x != 0) {
        total += x;
        stk.push(x);
      } else {
        int remove = stk.pop();
        total -= remove;
      }

    }

    System.out.println(total);

  }
}