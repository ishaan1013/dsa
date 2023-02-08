import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int r = Integer.parseInt(br.readLine());
    int c = Integer.parseInt(br.readLine());

    ArrayList<ArrayList<Integer>> room = new ArrayList<ArrayList<Integer>>();
    ArrayList<ArrayList<Boolean>> visit = new ArrayList<ArrayList<Boolean>>();

    ArrayList<ArrayList<ArrayList<Integer>>> pos = new ArrayList<ArrayList<ArrayList<Integer>>>();

    ArrayList<Integer> last = new ArrayList<Integer>();

    ArrayList<Integer> empty = new ArrayList<Integer>();
    room.add(empty);
    room.add(empty);
    for (int i = 1; i <= r; i++) {
      String[] line = br.readLine().split(" ");
      for (int j = 1; j <= c; j++) {
        String s = room.toString();
        System.out.println(s);
        room.add(i, Integer.parseInt(line[j - 1]));

        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(i);
        temp.add(j);
        pos.get(Integer.parseInt(line[j])).add(temp);

        if (i == r && j == c) {
          last.add(i);
          last.add(j);
        }
      }
    }

    Queue<ArrayList<Integer>> q = new LinkedList<ArrayList<Integer>>();
    q.add(last);
    while (q.size() > 0) {
      ArrayList<Integer> temp = q.peek();
      q.remove();

      ArrayList<ArrayList<Integer>> tempPos = pos.get(room.get(temp.get(0)).get(temp.get(1)));
      for (ArrayList<Integer> p : tempPos) {
        if (p.get(0) == 1 && p.get(1) == 1) {
          System.out.println("yes");
          return;
        } else if (!visit.get(p.get(0)).get(p.get(1))) {
          visit.get(p.get(0)).set(p.get(1), true);
          q.add(p);
        }
      }
    }
    System.out.println("no");
    return;

  }
}

// 3 10 8 14
// 1 11 12 12
// 6 2 3 9