// dp

import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static long n, w;
  static long[][] dp = new long[101][100005];

  public static void main(String[] args) throws IOException {
    String[] line1 = br.readLine().split(" ");
    n = Long.parseLong(line1[0]);
    w = Long.parseLong(line1[1]);

    long[] weight = new long[(int) n + 1];
    long[] val = new long[(int) n + 1];

    for (int i = 0; i < n; i++) {
      String[] line2 = br.readLine().split(" ");
      weight[i] = Long.parseLong(line2[0]);
      val[i] = Long.parseLong(line2[1]);
    }

    for (long[] row : dp)
      Arrays.fill(row, 0);

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= w; j++) {
        if (weight[i - 1] > j) {
          dp[i][j] = dp[i - 1][j];
        } else {
          dp[i][j] = Math.max(
              dp[i - 1][j],
              dp[i - 1][(int) (j - weight[i - 1])] + val[i - 1]);
        }
      }
    }
    System.out.println(dp[(int) n][(int) w]);
  }

}