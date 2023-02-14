import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] lengths = new int[2001];
    int[] boards = new int[4001];

    int totalL = 0, heights = 0;

    for (int i = 0; i < n; i++) {
      // increment frequency of length i at lengths[i]
      // e.g. inputting 30 -> lengths[30] +1
      lengths[Integer.parseInt(st.nextToken())]++;
    }

    for (int i = 1; i <= 2000; i++) {
      if (lengths[i] > 0) {
        if (lengths[i] > 1) {
          // board length calculation for multiple pieces of wood with equal length
          // e.g. 4 pieces of size 10 -> lengths[10] is 4 -> there can be 2 boards of size
          // 20 -> boards[20] +2
          boards[i * 2] += lengths[i] / 2;
        }
        for (int j = i + 1; j <= 2000; j++) {
          // for i=1 and j=10, boards[11] +1 (min of 2 and 1, for example)
          if (lengths[j] > 0)
            boards[i + j] += Math.min(lengths[i], lengths[j]);
        }
      }
    }

    for (int i = 1; i <= 4000; i++) {
      if (boards[i] > totalL) {
        // get max height
        totalL = boards[i];
        // reset max height, since it changes
        heights = 1;
      } else if (boards[i] == totalL) {
        // count frequency of max height
        heights++;
      }
    }

    System.out.println(totalL + " " + heights);

  }
}