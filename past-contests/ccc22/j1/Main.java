import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int r = Integer.parseInt(br.readLine());
    int s = Integer.parseInt(br.readLine());

    int n = r*8 + s*3;
    System.out.println(n-28);
  }
}