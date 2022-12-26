class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        res=[]
        
        if len(p) > len(s):
            return []
        pLetters, sLetters = {},{}
        
        for i, v in enumerate(p):
            pLetters[v] = 1 + pLetters.get(v, 0)
            sLetters[s[i]] = 1 + sLetters.get(s[i], 0)
            
        if sLetters == pLetters:
            res.append(0)
            
        left = 0
        
        for right in range(len(p), len(s)):
            sLetters[s[right]] = 1 + sLetters.get(s[right], 0)
            sLetters[s[left]] -= 1
            
            if sLetters[s[left]] == 0:
                sLetters.pop(s[left])
            
            left += 1
            
            if sLetters == pLetters:
                res.append(left)
                
        return res