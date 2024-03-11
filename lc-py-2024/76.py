class Solution:
    def minWindow(self, s: str, t: str) -> str:

        if len(s) == 1:
            if s == t:
                return s
            else:
                return ""

        minW = None
        start, end = 0, 0

        req = {}
        letters = {}
        nLetters = 0

        for ch in t:
            req[ch] = 1 + req.get(ch, 0)
            letters[ch] = 0

        while end < len(s):

            if nLetters < len(req):
                c = s[end]

                if c in req:
                    for k in letters.keys():
                        if letters[k] == (req[k] - 1):
                            nLetters += 1

                    letters[c] += 1

                end += 1

            else:
                if minW is None or (end-start+1) > len(minW):
                    minW = s[start:(end+1)]

                c = s[start]

                if c in req:
                    letters[c] -= 1

                    for k in letters.keys():
                        if letters[k] < req[k]:
                            nLetters -= 1

                start += 1

        return minW
