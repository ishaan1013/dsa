class Solution:
    def climbStairs(self, n: int) -> int:
        a = 1
        b = 2

        if n == 1:
            return a
        if n == 2:
            return b

        for i in range(n-2):
            temp = a
            a = b
            b += temp

        return b
