import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution {
  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    int rows = heights.length;
    int cols = heights[0].length;
    HashSet<List<Integer>> pacific = new HashSet<>();
    HashSet<List<Integer>> atlantic = new HashSet<>();

    for (int i = 0; i < cols; i++) {
      dfs(heights, 0, i, pacific, heights[0][i]);
      dfs(heights, rows - 1, i, atlantic, heights[rows - 1][i]);
    }
    for (int i = 0; i < rows; i++) {
      dfs(heights, i, 0, pacific, heights[i][0]);
      dfs(heights, i, cols - 1, atlantic, heights[i][cols - 1]);
    }

    pacific.retainAll(atlantic);
    return new ArrayList<List<Integer>>(pacific);
  }

  private void dfs(int[][] heights, int row, int col, HashSet<List<Integer>> rpt, int prev) {
    if (rpt.contains(Arrays.asList(row, col)) || row < 0 || col < 0 || row >= heights.length || col >= heights[0].length
        || heights[row][col] < prev) {
      return;
    }
    rpt.add(Arrays.asList(row, col));
    dfs(heights, row + 1, col, rpt, heights[row][col]);
    dfs(heights, row - 1, col, rpt, heights[row][col]);
    dfs(heights, row, col + 1, rpt, heights[row][col]);
    dfs(heights, row, col - 1, rpt, heights[row][col]);
  }
}