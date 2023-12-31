class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        longest = 0
        lst = set(nums)
        while lst:
            cur = lst.pop()  # random value
            hi, lo = cur + 1, cur - 1

            length = 1

            while hi in lst:
                lst.remove(hi)
                hi += 1
            length += hi - (cur + 1)

            while lo in lst:
                lst.remove(lo)
                lo -= 1
            length += cur - (lo + 1)

            longest = max(length, longest)

        return longest
