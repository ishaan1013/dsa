import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    HashMap<String, ArrayList<String>> same = new HashMap<String, ArrayList<String>>();
    HashMap<String, ArrayList<String>> diff = new HashMap<String, ArrayList<String>>();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int x = Integer.parseInt(br.readLine());
    for (int i = 0; i < x; i++) {
      String in = br.readLine();
      String[] s = in.split(" ");

      if (same.containsKey(s[0])) {
        same.get(s[0]).add(s[1]);
      } else {
        ArrayList<String> a = new ArrayList<String>();
        a.add(s[1]);
        same.put(s[0], a);
      }
      if (same.containsKey(s[1])) {
        same.get(s[1]).add(s[0]);
      } else {
        ArrayList<String> a = new ArrayList<String>();
        a.add(s[0]);
        same.put(s[1], a);
      }
    }
    int y = Integer.parseInt(br.readLine());
    for (int i = 0; i < y; i++) {
      String in = br.readLine();
      String[] s = in.split(" ");

      if (diff.containsKey(s[0])) {
        diff.get(s[0]).add(s[1]);
      } else {
        ArrayList<String> a = new ArrayList<String>();
        a.add(s[1]);
        diff.put(s[0], a);
      }
      if (diff.containsKey(s[1])) {
        diff.get(s[1]).add(s[0]);
      } else {
        ArrayList<String> a = new ArrayList<String>();
        a.add(s[0]);
        diff.put(s[1], a);
      }
    }

    int g = Integer.parseInt(br.readLine());
    int v = 0;
    for (int i = 0; i < g; i++) {
      String in = br.readLine();
      String[] s = in.split(" ");

      for (int j = 0; j < 3; j++) {
        if (same.containsKey(s[j])) {
          ArrayList<String> ppl = same.get(s[j]);
          for (int k = 0; k < ppl.size(); k++) {
            if (!Arrays.asList(s).contains(ppl.get(k))) {
              v++;
              same.get(ppl.get(k)).remove(s[j]);
            }
          }
        }

        if (diff.containsKey(s[j])) {
          ArrayList<String> ppl = diff.get(s[j]);
          for (int k = 0; k < ppl.size(); k++) {
            if (Arrays.asList(s).contains(ppl.get(k))) {
              v++;
              diff.get(ppl.get(k)).remove(s[j]);
            }
          }
        }
      }
    }
    System.out.println(v);
  }
}