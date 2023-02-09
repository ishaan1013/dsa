import java.io.*;
import java.util.*;

class Sect {
  int a, b, c;

  void add(char ch) {
    if (ch == 'A')
      a++;
    else if (ch == 'B')
      b++;
    else
      c++;
  }

  void remove(char ch) {
    if (ch == 'A')
      a--;
    else if (ch == 'B')
      b--;
    else
      c--;
  }

  Sect(int a, int b, int c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }
}

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    int n = s.length();
    int res = slide(s + s, n);
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == 'A')
        s = s.substring(0, i) + 'C' + s.substring(i + 1);
      else if (s.charAt(i) == 'C')
        s = s.substring(0, i) + 'A' + s.substring(i + 1);
    }
    res = Math.min(res, slide(s + s, n));
    System.out.println(res);

  }

  static int slide(String s, int n) {
    Sect total = new Sect(0, 0, 0);
    Sect a = new Sect(0, 0, 0);
    Sect b = new Sect(0, 0, 0);
    Sect c = new Sect(0, 0, 0);

    for (int i = 0; i < n; i++) {
      total.add(s.charAt(i));
    }
    int pos = 0;
    for (int i = 0; i < total.a; i++) {
      a.add(s.charAt(pos));
      pos++;
    }
    for (int i = 0; i < total.b; i++) {
      b.add(s.charAt(pos));
      pos++;
    }
    for (int i = 0; i < total.c; i++) {
      c.add(s.charAt(pos));
      pos++;
    }
    int swaps = Integer.MAX_VALUE;

    for (int i = 0; i < n; i++) {
      int currentSwaps = a.b + a.c + b.a
          + b.c - Math.min(a.b, b.a);
      swaps = Math.min(swaps, currentSwaps);

      a.remove(s.charAt(i));
      a.add(s.charAt(i + total.a));
      b.remove(s.charAt(i + total.a));
      b.add(s.charAt(i + total.a + total.b));
      c.remove(s.charAt(i + total.a + total.b));
      c.add(s.charAt(i + total.a + total.b + total.c));

      System.out.print("");
    }

    return swaps;

  }
}