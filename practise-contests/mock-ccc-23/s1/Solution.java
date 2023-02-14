import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[1]);
    int prev = 0;
    int res = 0;

    for (int i = 0; i < n; i++) {

      String[] in = br.readLine().split(" ");
      map.put(Integer.parseInt(in[0]), Integer.parseInt(in[1]));
    }

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

      if (entry.getValue() != prev) {
        res++;
        prev = entry.getValue();
      }
    }

    System.out.println(res);
  }
}