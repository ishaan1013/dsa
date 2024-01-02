class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = set()
        l = len(candidates)

        def decisionTree(index, lst, total):
            if target == total:
                res.add(tuple(lst))
                return
            if l <= index or total > target:
                return

            lst.append(candidates[index])
            decisionTree(index, lst, total + candidates[index])
            lst.pop()
            decisionTree(index + 1, lst, total)

        decisionTree(0, [], 0)
        return res
