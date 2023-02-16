import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int c = Integer.parseInt(br.readLine());
    String[] in1 = br.readLine().split(" ");
    String[] in2 = br.readLine().split(" ");

    int[] l1 = new int[c];
    int[] l2 = new int[c];

    for (int i = 0; i < c; i++) {
      l1[i] = Integer.parseInt(in1[i]);
      l2[i] = Integer.parseInt(in2[i]);
    }

    int count = 0;
    // odd = points touching
    // even = side touching
    for (int i = 0; i < c; i++) {
      boolean point = i % 2 == 1;

      if (l1[i] == 1) {
        if (i == 0) {
          count += 3;
        }

        else {

          if (l1[i - 1] == 1) {
            count += 1;
          } else {
            count += 3;
          }
        }

      }

      if (l2[i] == 1) {
        if (i == 0) {
          if (l1[i] == 1) {
            if (point) {
              count += 3;
            } else {
              count += 1;
            }
          } else {
            count += 3;
          }
        } else {
          if (l2[i - 1] == 1 && l1[i] == 1) {
            if (point) {
              count += 1;
            } else {
              count -= 1;
            }
          } else if (l2[i - 1] == 1 && l1[i] == 0) {
            count += 1;
          } else if (l2[i - 1] == 0 && l1[i] == 1) {
            if (point) {
              count += 3;
            } else {
              count += 1;
            }
          } else {
            count += 3;
          }
        }

      }

    }

    System.out.println(count);

  }
}