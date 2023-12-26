class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if len(prices) == 1:
            return 0

        start = prices[0]
        end = -1
        profit = 0

        for p in prices[1:]:
            if p < start:
                start = p
                end = -1
            elif p > end:
                new = p - start
                if (end - start) < new and new > 0 and new > profit:
                    profit = new
                    end = p

        return profit
