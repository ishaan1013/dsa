class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:

        if not strs:
            return [[""]]

        hm = {}

        for string in strs:
            freq = [0] * 26

            for c in string:
                freq[ord(c) - ord("a")] += 1

            key = tuple(freq)
            if not key in hm:
                hm[key] = []
            hm[key].append(string)

        return hm.values()
