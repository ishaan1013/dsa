from typing import List


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0

        r = len(grid)
        c = len(grid[0])
        islands = 0

        def search(x, y):
            if x < 0 or y < 0 or x >= r or y >= c:
                return

            if grid[x][y] != "1":
                return

            grid[x][y] = "0"

            search(x-1, y)
            search(x+1, y)
            search(x, y-1)
            search(x, y+1)

        for x in range(r):
            for y in range(c):
                if grid[x][y] == "1":
                    search(x, y)
                    islands += 1

        return islands
