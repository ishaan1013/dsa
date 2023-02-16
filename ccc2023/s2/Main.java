import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    String[] heights = br.readLine().split(" ");
    int[] h = new int[n];
    int[] res = new int[n];
    Arrays.fill(res, Integer.MAX_VALUE);
    for (int i = 0; i < n; i++) {
      h[i] = Integer.parseInt(heights[i]);
    }

    // odd
    res[0] = 0;
    for (int i = 1; i < n; i++) {
      int reach = Math.min(i, n - i - 1);
      int sum = 0;
      for (int x = 1; x <= reach; x++) {
        int dif = Math.abs(h[i - x] - h[i + x]);
        sum += dif;
        res[x * 2] = Math.min(res[x * 2], sum);
        // System.out.println("res at " + (x * 2) + " is " + res[x * 2]);
      }
    }

    // even
    for (int i = 0; i < n; i++) {
      int reach = Math.min(i, n - i - 2);
      int sum = 0;
      for (int x = 0; x <= reach; x++) {
        int dif = Math.abs(h[i - x] - h[i + x + 1]);
        sum += dif;
        res[x * 2 + 1] = Math.min(res[x * 2 + 1], sum);
      }
    }

    for (int i = 0; i < n; i++) {
      System.out.print(res[i] + " ");
    }

  }
}