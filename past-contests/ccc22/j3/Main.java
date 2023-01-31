import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String in = br.readLine();

    // string letters, direction
    String sD[] = in.split("[0-9]+");
    // # turns
    String t[] = in.split("[^0-9]+");

    for (int i = 0; i < sD.length; i++) {
      String dir = sD[i].substring(sD[i].length() - 1).equals("+") ? " tighten " : " loosen ";
      System.out.println(sD[i].substring(0, sD[i].length() - 1) + dir + t[i + 1]);
    }
  }
}