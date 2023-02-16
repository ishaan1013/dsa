import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    String[] heights = br.readLine().split(" ");
    int[] h = new int[n];
    int[] res = new int[n];
    for (int i = 0; i < n; i++) {
      h[i] = Integer.parseInt(heights[i]);
    }

    for (int i = 1; i <= n; i++) {
      int total = Integer.MAX_VALUE;
      for (int j = 0; j < n - (i - 1); j++) {

        int[] newH = Arrays.copyOfRange(h, j, j + i);
        int iter = i % 2 == 0 ? i / 2 : (i + 1) / 2;
        int sum = 0;
        for (int x = 0; x < iter; x++) {
          int val = Math.abs(newH[x] - newH[i - (x + 1)]);
          sum += val;
        }
        total = Math.min(total, sum);
      }
      res[i - 1] = total;

    }

    for (int i = 0; i < n; i++) {
      System.out.print(res[i] + " ");
    }

  }
}