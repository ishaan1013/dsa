import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(n, Collections.reverseOrder());

    for (int i = 0; i < n; i++) {
      int in = Integer.parseInt(br.readLine());
      pq.add(in);
    }

    for (int i = 0; i < n; i++) {
      int a = pq.remove();
      System.out.print(a + " ");
    }
    // ??????????

  }
}