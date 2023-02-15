// dfs, flood fill

import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n, m;
  static String[][] grid = new String[1005][1005];
  static int[][] visit = new int[1005][1005];

  static int[] start = new int[2];
  static int[] end = new int[2];

  public static void main(String[] args) throws IOException {

    for (int[] row : visit) {
      Arrays.fill(row, Integer.MAX_VALUE);
    }

    String[] line1 = br.readLine().split(" ");
    n = Integer.parseInt(line1[0]);
    m = Integer.parseInt(line1[1]);

    for (int i = 0; i < n; i++) {
      String[] row = br.readLine().split("");
      grid[i] = row;
      int startI = Arrays.asList(row).indexOf("s");
      if (startI != -1) {
        start[0] = i;
        start[1] = startI;
      }
      int endI = Arrays.asList(row).indexOf("e");
      if (endI != -1) {
        end[0] = i;
        end[1] = endI;
      }
    }
    dfs(start[0], start[1], 0);

    System.out.println(visit[end[0]][end[1]] == Integer.MAX_VALUE ? -1 : visit[end[0]][end[1]] - 1);
  }

  static void dfs(int x, int y, int count) {

    if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y].equals("X") || count > visit[x][y])
      return;

    visit[x][y] = count;
    dfs(x + 1, y, count + 1);
    dfs(x - 1, y, count + 1);
    dfs(x, y + 1, count + 1);
    dfs(x, y - 1, count + 1);
  }
}