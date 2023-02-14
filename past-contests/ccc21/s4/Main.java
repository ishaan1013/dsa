// dijkstra

import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n, w, d;
  static int maximum = 200005;
  static Map<Integer, Integer>[] distance = new Map[maximum];
  static int[] order = new int[maximum];
  static List<Integer>[] walk = new List[maximum];
  static {
    for (int i = 0; i < maximum; i++)
      walk[i] = new ArrayList<>();
    for (int i = 0; i < maximum; i++)
      distance[i] = new HashMap<>();
  }

  public static void main(String[] args) throws IOException {
    String[] line1 = br.readLine().split(" ");
    n = Integer.parseInt(line1[0]);
    w = Integer.parseInt(line1[1]);
    d = Integer.parseInt(line1[2]);

    for (int i = 0; i < w; i++) {
      String[] walkway = br.readLine().split(" ");
      walk[Integer.parseInt(walkway[0])].add(Integer.parseInt(walkway[1]));
    }
    String[] initialOrder = br.readLine().split(" ");
    for (int i = 1; i <= n; i++) {
      order[i] = Integer.parseInt(initialOrder[i - 1]);
    }
    for (int i = 1; i <= n; i++) {
      bfs(i);
    }

    int[] out = new int[d];

    for (int i = 0; i < d; i++) {
      String[] swap = br.readLine().split(" ");
      int from = Integer.parseInt(swap[0]);
      int to = Integer.parseInt(swap[1]);
      int temp = order[from];
      order[from] = order[to];
      order[to] = temp;
      int res = Integer.MAX_VALUE;
      for (int j = 1; j <= n; j++) {
        if (order[j] == n) {
          res = Math.min(res, j - 1);
        } else
          res = Math.min(res, j - 1 + distance[order[j]].getOrDefault(n, Integer.MAX_VALUE / 2));
      }
      out[i] = res;
    }

    for (int i = 0; i < d; i++) {
      System.out.println(out[i]);
    }

  }

  public static void bfs(int i) {
    Queue<Integer> q = new LinkedList<>();
    q.add(i);
    distance[i].put(i, 0);
    while (!q.isEmpty()) {
      int current = q.poll();
      for (int next : walk[current]) {
        if (distance[i].get(current) + 1 < distance[i].getOrDefault(next, Integer.MAX_VALUE / 2)) {
          q.add(next);
          distance[i].put(next, distance[i].get(current) + 1);
        }
      }
    }
  }

}