class Solution {
  int m;
  int n;

  public int numIslands(char[][] grid) {
    m = grid.length;
    if (m == 0)
      return 0;
    n = grid[0].length;
    int islandCount = 0;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          markIslands(grid, i, j);
          ++islandCount;
        }
      }
    }
    return islandCount;
  }

  void markIslands(char[][] grid, int i, int j) {
    // check for out of bounds
    if (
    // too far left or up
    i < 0 || j < 0 ||
    // too far right or down
        i >= m || j >= n ||
        // not in bounds of the same island
        grid[i][j] != '1')
      return;

    grid[i][j] = '0';
    // scan all directions for the same island
    markIslands(grid, i + 1, j);
    markIslands(grid, i - 1, j);
    markIslands(grid, i, j + 1);
    markIslands(grid, i, j - 1);
  }
}