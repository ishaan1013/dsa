import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String n = br.readLine();
    String h = br.readLine();

    HashMap<Character, Integer> freq = new HashMap<Character, Integer>();
    HashMap<Character, Integer> window = new HashMap<Character, Integer>();

    for (int i = 0; i < n.length(); i++) {
      char c = n.charAt(i);
      if (freq.containsKey(c)) {
        freq.put(c, freq.get(c) + 1);
      } else {
        freq.put(c, 1);
      }
    }

    ArrayList<String> list = new ArrayList<String>();

    for (int i = 0; i < h.length() - n.length() + 1; i++) {
      if (i == 0) {
        for (int j = 0; j < n.length(); j++) {
          char c = h.charAt(j);
          if (window.containsKey(c)) {
            window.put(c, window.get(c) + 1);
          } else {
            window.put(c, 1);
          }
        }
      } else {
        char c = h.charAt(i - 1);
        window.put(c, window.get(c) - 1);
        if (window.get(c) == 0) {
          window.remove(c);
        }

        c = h.charAt(i + n.length() - 1);
        if (window.containsKey(c)) {
          window.put(c, window.get(c) + 1);
        } else {
          window.put(c, 1);
        }
      }

      if (freq.equals(window)) {
        String s = h.substring(i, i + n.length());
        if (!list.contains(s)) {
          list.add(s);
        }
      }
    }

    System.out.println(list.size());

  }
}