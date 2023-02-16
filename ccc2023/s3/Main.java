import java.io.*;
import java.util.*;

public class Main {
  static int n, m, r, c;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] in = br.readLine().split(" ");
    n = Integer.parseInt(in[0]);
    m = Integer.parseInt(in[1]);
    r = Integer.parseInt(in[2]);
    c = Integer.parseInt(in[3]);

    String[] res = solve();
    for (String str : res) {
      System.out.println(str);
    }

  }

  static String[] solve() {
    if (n == r && m != c || n != r && m == c) {
      return new String[] { "IMPOSSIBLE" };
    }

    String[] cz = { "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
        "w", "x", "y", "z" };

    String[] res = new String[n];

    int cols;
    if (c % 2 == 1) {
      cols = (c + 1) / 2;
    } else {
      cols = c / 2;
    }
    for (int x = 0; x < n; x++) {

      boolean isRow = x < r;
      StringBuilder sb = new StringBuilder();
      for (int y = 0; y < m; y++) {
        if (y < cols || y > m - (cols + 1)) {
          sb.append("a");
        } else {
          if (isRow) {
            sb.append("a");
          } else {
            Random r = new Random();
            char c = (char) (r.nextInt(25) + 'b');
            sb.append(c);
            // sb.append(cz[(y + x) % 24]);
            // sb.append("c");
          }
        }
      }

      res[x] = sb.toString();
    }
    return res;

  }
}