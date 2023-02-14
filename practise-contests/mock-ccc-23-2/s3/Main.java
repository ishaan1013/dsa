import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] res = new int[n][2]

    for (int i = 0; i < n; i++) {
      String[] in = br.readLine().split(" ");
      int n = in[0];
      int k = in[1];
      int a = in[2];
      int b = in[3];
      int c = in[4];

      if (n == 1) {
        res[i] = {0, 0};
      } else{
        
      }

    }

  }
}