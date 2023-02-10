import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[][] grid = new String[3][3];
    for (int i = 0; i < 3; i++) {
      String[] row = br.readLine().split(" ");
      grid[i] = (row);
    }

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (grid[i][j].equals("X")) {
          grid[i][j] = getX(grid, i, j) + "";
        }
        if (grid[i][j].equals("Y")) {
          grid[i][j] = getX(grid, i, j) + "";
        }
      }
    }

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        System.out.print(grid[i][j] + " ");
      }
      System.out.println();
    }

  }

  static int getX(String[][] grid, int x, int y) {
    // left and right
    if (x == 1 && !grid[x - 1][y].equals("X") && !grid[x + 1][y].equals("X")) {
      return (Integer.parseInt(grid[x - 1][y]) + Integer.parseInt(grid[x + 1][y])) / 2;
    }
    // above and below
    if (y == 1 && !grid[x][y - 1].equals("Y") && !grid[x][y + 1].equals("Y")) {
      return (Integer.parseInt(grid[x][y - 1]) + Integer.parseInt(grid[x][y + 1])) / 2;
    }

    // right
    if (x == 0 && !grid[x + 1][y].equals("X") && !grid[x + 2][y].equals("X")) {
      return (Integer.parseInt(grid[x + 1][y]) + (Integer.parseInt(grid[x + 1][y]) - Integer.parseInt(grid[x + 2][y])));
    }
    // left
    if (x == 2 && !grid[x - 1][y].equals("X") && !grid[x - 2][y].equals("X")) {
      return (Integer.parseInt(grid[x - 1][y]) + (Integer.parseInt(grid[x - 1][y]) - Integer.parseInt(grid[x - 2][y])));
    }

    // down
    if (y == 0 && !grid[x][y + 1].equals("Y") && !grid[x][y + 2].equals("Y")) {
      return (Integer.parseInt(grid[x][y + 1]) + (Integer.parseInt(grid[x][y + 1]) - Integer.parseInt(grid[x][y + 2])));
    }
    // up
    if (y == 2 && !grid[x][y - 1].equals("Y") && !grid[x][y - 2].equals("Y")) {
      return (Integer.parseInt(grid[x][y - 1]) + (Integer.parseInt(grid[x][y - 1]) - Integer.parseInt(grid[x][y - 2])));
    }

    System.out.println("error");
    return 0;

  }

}

/*
 * 8 9 10
 * 16 X 20
 * 24 X 30
 * 
 * x at [1,1]
 * if (there is a value to the left and right)
 * x = (left + right) / 2
 * if (there is a value above and below)
 * x = (above + below) / 2
 * 
 * if (x is on an edge && there is a value beside it and further away)
 * x = (beside + (beside-further) )
 * 
 * 
 * 
 * 
 */