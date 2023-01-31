import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int r = Integer.parseInt(br.readLine());
    int c = Integer.parseInt(br.readLine());

    HashSet<Integer> rows = new HashSet<>();
    HashSet<Integer> cols = new HashSet<>();

    int k = Integer.parseInt(br.readLine());
    for (int i = 0; i < k; i++) {
      String[] change = br.readLine().split(" ");
      int val = Integer.parseInt(change[1]);
      if (change[0].equals("C")) {
        if (cols.contains(val)) {
          cols.remove(val);
        } else {
          cols.add(val);
        }
      } else {
        if (rows.contains(val)) {
          rows.remove(val);
        } else {
          rows.add(val);
        }
      }
    }

    int total = 0;
    for (int i = 0; i < r; i++) {
      if (rows.contains(i + 1)) {
        total += c - cols.size();
      } else {
        total += cols.size();
      }
    }

    System.out.println(total);

  }
}