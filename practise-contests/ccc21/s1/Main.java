import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    ArrayList<Integer> h = new ArrayList<>();
    ArrayList<Integer> w = new ArrayList<>();

    String[] heights = br.readLine().split(" ");
    for (String i : heights) {
      h.add(Integer.parseInt(i));
    }

    String[] widths = br.readLine().split(" ");
    for (String i : widths) {
      w.add(Integer.parseInt(i));
    }

    double total = 0;
    for (int i = 0; i < n; i++) {
      double area = ((h.get(i) + h.get(i + 1)) / 2.0) * w.get(i);
      total += area;
      // System.out.printf("Area = %f%n", area);
      // System.out.printf("Total = %f%n", total);
    }
    System.out.printf("%n%n%f", total);
  }
}