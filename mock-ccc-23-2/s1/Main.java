import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    HashSet<Integer> fibs = getFibs();
    String[] res = new String[n];

    for (int i = 0; i < n; i++) {
      int in = Integer.parseInt(br.readLine());

      if (composite(in) && fibs.contains(in)) {
        res[i] = "YES";
      } else {
        res[i] = "NO";
      }
    }

    for (String i : res) {
      System.out.println(i);
    }

  }

  static HashSet<Integer> getFibs() {
    HashSet<Integer> fibs = new HashSet<>();
    int x = 0;
    int y = 1;
    fibs.add(x);
    fibs.add(y);

    while (y <= 100000) {
      int temp = y;
      y += x;
      x = temp;
      if (y <= 100000)
        fibs.add(y);
    }
    return fibs;
  }

  static boolean composite(int n) {
    if (n <= 1) {
      return false;
    }
    for (int i = 2; i < Math.sqrt(n); i++) {
      if (n % i == 0) {
        return true;
      }
    }
    return false;
  }
}