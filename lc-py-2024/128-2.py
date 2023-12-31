class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if not nums:
            return 0

        sort = sorted(nums)

        current = 1
        longest = 1

        for i in range(1, len(sort)):
            if sort[i] != sort[i-1]:
                if sort[i] == sort[i-1] + 1:
                    current += 1
                else:
                    current = 1

            if current > longest:
                longest = current

        return longest
