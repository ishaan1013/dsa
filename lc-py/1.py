class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hm={}
        for i,v in enumerate(nums):
            if (target-v) in hm:
                return[hm[target-v], i]
            else:
                hm[v] = i