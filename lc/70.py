class Solution:
    def climbStairs(self, n: int) -> int:
        x, y = 1, 1
        for i in range(n):
            x, y = y, x + y
            
        return x