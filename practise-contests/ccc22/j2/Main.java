import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    int gold = 0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      int p = Integer.parseInt(br.readLine());
      int f = Integer.parseInt(br.readLine());
      int total = p * 5 - f * 3;
      if (total > 40) {
        gold++;
      }
    }
    String res = gold == n ? Integer.toString(gold) + "+" : Integer.toString(gold);
    System.out.println(res);
  }
}