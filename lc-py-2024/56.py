class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if len(intervals) <= 1:
            return intervals

        intervals.sort(key=lambda pair: pair[0])
        res, cur = [], intervals[0]

        for i, v in enumerate(intervals[1:]):
            if v[0] > cur[1]:
                res.append(cur)
                cur = v
            else:
                cur = [min(cur[0], v[0]), max(cur[1], v[1])]

        res.append(cur)
        return res
