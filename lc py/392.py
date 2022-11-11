class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        
        if len(s) > len(t): return False
        if s == t: return True
        if len(t) == 0 and len(s) != 0: return False
        if len(s) == 0 or (len(s) == 0 and len(t) == 0): return True
               
        count = 0
        for i, v in enumerate(t):
            if s[count] == v:
                count+=1
                
                if count == len(s):
                    return True
            
        return False
        