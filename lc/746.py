class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        pos = 0
        a,b=cost[0], cost[1]
        
        for i in range(2, len(cost)):
            pos = cost[i] + min(a,b)
            a,b=b,pos
            
        return min(a,b)