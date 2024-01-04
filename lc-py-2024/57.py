class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:

        lo, hi = newInterval[0], newInterval[1]

        res = []

        for i, v in enumerate(intervals):
            if hi < v[0]:
                res.append(newInterval)
                return res + intervals[i:]
            if lo > v[1]:
                res.append(v)
            else:  # contained
                newInterval = [min(lo, v[0]), max(hi, v[1])]

        # reaches this point if there's no pre-existing interval greater than newInterval, without overlap
        res.append(newInterval)
        return res
