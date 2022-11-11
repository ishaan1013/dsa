class Solution:
    def longestPalindrome(self, s: str) -> int:
        letters="".join(set(s))
        res=0
        odds=0
        for i in letters:
            res+=s.count(i)
            print()
            if s.count(i)%2==1:
                odds+=1
        
        if odds > 0:
            res -= (odds - 1) 
        return res
