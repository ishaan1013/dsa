class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap = {}
        for i, v in enumerate(nums):
            if ((target-v) in hashmap):
                return [hashmap[target-v], i]
            else:
                hashmap[v] = i
