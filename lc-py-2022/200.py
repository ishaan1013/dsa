class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        islands = 0
        
        for i1, v1 in enumerate(grid):
            for i2, v2 in enumerate(grid[0]):
                if grid[i1][i2] == "1":
                    self.search(grid, i1, i2)
                    islands += 1
        
        return islands
    
    def search(self, grid, i1, i2):
        if grid[i1][i2] != "1":
            return
        
        grid[i1][i2] = "2"
        
        if i1 > 0:
            self.search(grid, i1-1, i2)
        if i1 < len(grid)-1:
            self.search(grid, i1+1, i2)
        if i2 > 0:
            self.search(grid, i1, i2-1)
        if i2 < len(grid[0])-1:
            self.search(grid, i1, i2+1)