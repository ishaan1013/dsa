class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        left = 0
        right = sum(nums)
        
        for i, v in enumerate(nums):
            right -= v
            
            if left == right:
                return i
            
            left += v
            
        return -1
        