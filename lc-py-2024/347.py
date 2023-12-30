class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        hm = defaultdict(int)

        for n in nums:
            hm[n] += 1

        reverse = sorted(hm, key=hm.get, reverse=True)

        return reverse[:k]
