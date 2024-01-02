class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        if not heights:
            return None

        m, n = len(heights), len(heights[0])

        pacific, atlantic = set(), set()

        def flood(x, y, history, prev):
            if x < 0 or y < 0 or x >= m or y >= n or (x, y) in history or heights[x][y] < prev:
                return

            history.add((x, y))

            flood(x-1, y, history, heights[x][y])
            flood(x+1, y, history, heights[x][y])
            flood(x, y-1, history, heights[x][y])
            flood(x, y+1, history, heights[x][y])

        for row in range(m):
            flood(row, 0, pacific, heights[row][0])
            flood(row, n-1, atlantic, heights[row][n-1])
        for col in range(n):
            flood(0, col, pacific, heights[0][col])
            flood(m-1, col, atlantic, heights[m-1][col])

        return list(pacific.intersection(atlantic))
