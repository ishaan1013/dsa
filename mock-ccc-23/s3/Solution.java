import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int m = Integer.parseInt(input[1]);
    int a = Integer.parseInt(input[2]);
    int b = Integer.parseInt(input[3]);

    int[] blacks = new int[m + 1];
    int[][] dp = new int[2][m + 1];
    Arrays.fill(dp[0], Integer.MAX_VALUE / 2);
    Arrays.fill(dp[1], Integer.MAX_VALUE / 2);
    dp[0][0] = dp[1][0] = 0;

    for (int i = 0; i < n; i++) {
      char[] in = br.readLine().toCharArray();
      for (int j = 1; j <= m; j++) {
        if (in[j - 1] == '#') {
          blacks[j]++;
        }
      }
    }
    blacks = accumulate(blacks);
    for (int i = 0; i < m; i++) {
      for (int j = a; j <= b; j++) {
        if (i + j > m)
          break;
        dp[0][i + j] = Math.min(dp[0][i + j], dp[1][i] + blacks[i + j] - blacks[i]);
        dp[1][i + j] = Math.min(dp[1][i + j], dp[0][i] + n * j - blacks[i + j] + blacks[i]);
      }
    }

    System.out.println(Math.min(dp[0][m], dp[1][m]));

  }

  static int[] accumulate(int[] arr) {
    if (arr.length == 0)
      return arr;
    for (int i = 1; i < arr.length; i++) {
      arr[i] += arr[i - 1];
    }
    return arr;
  }

}
