class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:

        if not nums:
            return []

        res = [1]

        for i in range(len(nums)):
            res.append(res[i] * nums[i])

        suffix = 1

        for i in range(len(nums) - 1, 0, -1):
            res[i] *= suffix
            suffix *= nums[i]

        return res
