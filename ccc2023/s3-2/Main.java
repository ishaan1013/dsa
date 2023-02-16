import java.io.*;
import java.util.*;

public class Main {
  static int n, m, r, c;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] in = br.readLine().split(" ");
    n = 2;
    m = 2;
    r = Integer.parseInt(in[2]);
    c = Integer.parseInt(in[3]);

    String[] res = new String[2];
      if (r == 2 && c == 2) {
        res[0] = "aa";
        res[1] = "aa";
      }
      if (r == 1 && c == 0) {
        res[0] = "aa";
        res[1] = "bc";
      }
      if (r == 0 && c == 1) {
        res[0] = "ab";
        res[1] = "cb";
      }
      if (r == 0 && c == 2) {
        res[0] = "ab";
        res[1] = "ab";
      }
      if (r == 2 && c == 0) {
        res[0] = "bb";
        res[1] = "aa";
      }
      if (r == 1 && c == 1) {
        res[0] = "aa";
        res[1] = "ac";
      }
      if (r == 0 && c == 0) {
        res[0] = "ab";
        res[1] = "bc";
      }

      System.out.println(res[0]);
      System.out.println(res[1]);
    }

  }
}