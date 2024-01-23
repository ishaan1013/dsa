class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        dp = [[0 for _ in range(len(text2)+1)] for _ in range(len(text1)+1)]
        for x, c1 in enumerate(text1):
            i = len(text1) - x - 1
            for y, c2 in enumerate(text2):
                j = len(text2) - y - 1
                if c1 == c2:
                    dp[i][j] = dp[i+1][j+1] + 1
                else:
                    dp[i][j] = max(dp[i][j+1], dp[i+1][j])

        return dp[0][0]
