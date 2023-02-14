// dfs

import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n, m, a, b;
  static boolean[][] connections = new boolean[2005][2005];
  static boolean[] visit = new boolean[2005];

  public static void main(String[] args) throws IOException {
    String[] line1 = br.readLine().split(" ");
    n = Integer.parseInt(line1[0]);
    m = Integer.parseInt(line1[1]);
    a = Integer.parseInt(line1[2]);
    b = Integer.parseInt(line1[3]);

    for (int i = 1; i <= m; i++) {
      String[] line2 = br.readLine().split(" ");
      int dest1 = Integer.parseInt(line2[0]);
      int dest2 = Integer.parseInt(line2[1]);

      connections[dest1][dest2] = true;
      connections[dest2][dest1] = true;
    }

    dfs(a);
    System.out.println(visit[b] ? "GO SHAHIR!" : "NO SHAHIR!");
  }

  static void dfs(int x) {
    visit[x] = true;
    for (int y = 1; y <= n; y++) {
      if (connections[x][y] && !visit[y]) {
        // System.out.println("connecting from " + x + " to " + y);
        dfs(y);
      }
    }
  }

}