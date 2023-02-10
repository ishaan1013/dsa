import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    ArrayList<int[]> res = new ArrayList<>();

    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());
      res.add(primes(n));
    }

    for (int[] r : res) {
      System.out.println(r[0] + " " + r[1]);
    }

  }

  public static int[] primes(int n) {
    for (int i = 1; i < n; i++) {
      if (prime(i) && prime(2 * n - i)) {
        return new int[] { i, 2 * n - i };
      }
    }
    return new int[] {};
  }

  public static boolean prime(int n) {
    if (n == 1)
      return false;
    for (int i = 2; i < Math.sqrt(n) + 1; i++) {
      if (n % i == 0)
        return false;
    }
    return true;
  }
}