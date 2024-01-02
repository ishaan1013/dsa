class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        pos, neg, zero = set(), set(), []
        res = set()

        for n in nums:
            if n > 0:
                pos.add(n)
            elif n < 0:
                neg.add(n)
            else:
                zero.append(n)

        if zero:
            if len(zero) >= 3:
                res.add((0, 0, 0))

            for n in pos:
                if n * -1 in neg:
                    res.add(n*-1, 0, n)

        for i in range(len(pos)):
            for j in range(i+1, len(pos)):
                tgt = (i + j) * -1

                if tgt in neg:
                    res.add(tuple(sorted([i, j, tgt])))

        for i in range(len(neg)):
            for j in range(i+1, len(neg)):
                tgt = (i + j) * -1

                if tgt in pos:
                    res.add(tuple(sorted([i, j, tgt])))

        return res
