class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        
        letterMap={}
        
        for i in s:
            if i not in letterMap:
                letterMap[i] = 1
            else:
                letterMap[i] += 1
                
        for i in t:
            if i in letterMap:
                if letterMap[i] > 0:
                    letterMap[i] -= 1
                    
                    if letterMap[i] == 0:
                        del letterMap[i]
            
        return not letterMap