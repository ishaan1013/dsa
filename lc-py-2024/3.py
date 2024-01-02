class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:

        hm = defaultdict(int)
        longest, start = 0, 0

        for i, c in enumerate(s):
            if c in hm and start <= hm[c]:
                start = hm[c] + 1
            hm[c] = i
            if i-start >= longest:
                longest = i-start+1

        return longest
