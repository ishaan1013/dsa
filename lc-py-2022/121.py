class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if len(prices) == 1:
            return 0
        
        buy = 0
        sell = 1
        maxSell = 0
        for i in (prices[:-1]):
            if prices[buy] < prices[sell]:
                if prices[sell]-prices[buy] > maxSell:
                    maxSell = prices[sell] - prices[buy]
            else:
                buy = sell
            sell+=1
        return maxSell