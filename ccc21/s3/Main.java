import java.io.*;
import java.util.*;

public class Main {

  static long sum(long n) {
    long res = 0;
    for (int i = 0; i < people.length; i++) {
      person c = people[i];
      long pos = Math.abs(c.p - n);
      if (pos > c.d) {
        res += ((pos - c.d) * c.w);
      }
    }
    return res;
  }

  static class person {
    long p, w, d;

    person(long p, long w, long d) {
      this.p = p;
      this.w = w;
      this.d = d;
    }

  }

  static person[] people;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    people = new person[n];
    long min = Long.MAX_VALUE;
    long max = Long.MIN_VALUE;
    long res = min;

    // highest & lowest pos
    for (int i = 0; i < n; i++) {
      String[] line = br.readLine().split(" ");
      long p = Long.parseLong(line[0]);
      long w = Long.parseLong(line[1]);
      long d = Long.parseLong(line[2]);
      people[i] = new person(p, w, d);
      min = Math.min(min, p);
      max = Math.max(max, p);
    }

    while (min <= max) {
      long m = (min + max) / 2;
      long mid = sum(m);
      long left = sum(m - 1);
      long right = sum(m + 1);
      res = Math.min(mid, res);
      if (left <= right) {
        max = m - 1;
      } else {
        min = m + 1;
      }
    }

    System.out.println(res);

  }

}
