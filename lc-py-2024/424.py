class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        hm = defaultdict(int)
        longest, start, maxfreq = 0, 0, 0

        for i, c in enumerate(s):
            hm[c] += 1
            maxfreq = max(hm[c], maxfreq)

            cur = i - start + 1

            if cur - maxfreq > k:
                hm[s[start]] -= 1
                start += 1
                cur -= 1

            longest = max(longest, cur)

        return longest
