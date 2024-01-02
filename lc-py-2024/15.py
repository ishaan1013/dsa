class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        pos, neg = defaultdict(int), defaultdict(int)
        z = 0

        res = []

        for n in nums:
            if n > 0:
                pos[n] += 1
            elif n < 0:
                neg[n] += 1
            else:
                z += 1

        if z:
            if z >= 3:
                res.append((0, 0, 0))
            for p in pos:
                if -p in neg:
                    res.append((-p, 0, p))

        lpos = list(pos.items())
        lneg = list(neg.items())

        for index, (k, v) in enumerate(lpos):
            for k2, _ in lpos[index:]:
                tgt = -(k+k2)
                if tgt in neg:
                    if k != k2 or (k == k2 and v > 1):
                        res.append((k, k2, tgt))

        for index, (k, v) in enumerate(lneg):
            for k2, _ in lneg[index:]:
                tgt = -(k+k2)
                if tgt in pos:
                    if k != k2 or (k == k2 and v > 1):
                        res.append((k, k2, tgt))

        return res
