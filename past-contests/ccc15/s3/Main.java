import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int g = Integer.parseInt(br.readLine());
    int p = Integer.parseInt(br.readLine());

    ArrayList<Integer> spots = new ArrayList<>();
    for (int i = 1; i <= g; i++) {
      spots.add(i);
    }

    int res = 0;
    for (int i = 0; i < p; i++) {
      int plane = Integer.parseInt(br.readLine());

      // spots get removed so can't do g-1
      int l = 0, h = spots.size() - 1;
      int pos = -1;

      while (l <= h) {
        int m = (l + h) / 2;
        int middle = spots.get(m);
        if (middle == plane) {
          pos = m;
          break;
        } else if (middle < plane) {
          pos = m;
          l = m + 1;
        } else {
          h = m - 1;
        }
      }

      if (pos != -1) {
        spots.remove(pos);
        res++;
      } else {
        break;
      }
    }

    System.out.println(res);

  }
}