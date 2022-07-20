class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        unique_pairs = set(zip(s,t))
        return len(unique_pairs) == len(set(s)) == len(set(t))