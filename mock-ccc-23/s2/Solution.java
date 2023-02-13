import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int res = 0;

    for (int i = 0; i < n; i++) {
      int a = Integer.parseInt(br.readLine());

      if (prime(a))
        res += 2;
    }

    System.out.println(res);
  }

  public static boolean prime(int n) {
    if (n == 1)
      return false;
    for (int i = 2; i < Math.sqrt(n) + 1; i++) {
      if (n % i == 0)
        return false;
    }
    return true;
  }

}