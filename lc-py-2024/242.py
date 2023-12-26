class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        hm = {}
        for c in s:
            hm[c] = 1 if c not in hm else (hm[c] + 1)
        for c in t:
            if c in hm:
                hm[c] -= 1
                if hm[c] == 0:
                    hm.pop(c)

        if len(hm) > 0:
            return False
        return True
