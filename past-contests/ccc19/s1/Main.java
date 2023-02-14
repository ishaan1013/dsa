import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    int h = 0, v = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'H')
        h++;
      else
        v++;
    }

    if (h % 2 == 0 && v % 2 == 0) {
      System.out.println("1 2");
      System.out.println("3 4");
    } else if (h % 2 == 1 && v % 2 == 0) {
      System.out.println("3 4");
      System.out.println("1 2");
    } else if (h % 2 == 0 && v % 2 == 1) {
      System.out.println("2 1");
      System.out.println("4 3");
    } else {
      System.out.println("4 3");
      System.out.println("2 1");
    }

  }
}