import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
    for (int i = 0; i < n; i++) {
      String[] line = br.readLine().split(" ");
      map.put(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
    }

    double total = 0;
    int prev = -1;
    for (Integer key : map.keySet()) {
      if (prev != -1) {
        double speed = Math.abs((map.get(key) - map.get(prev)) / (double) (key - prev));
        total = Math.max(total, speed);
      }
      prev = key;
    }

    System.out.println(total);
  }
}