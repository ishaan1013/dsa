class Solution:
    def longestPalindrome(self, s: str) -> int:
        freq = {}
  
        for i in s:
            if i in freq:
                freq[i] += 1
            else:
                freq[i] = 1
                
        pLength = 0
        midOdd = 0
               
        print(str(freq))
        for i in freq:
            
            print(i+": "+str(freq[i]))
            
            if freq[i] % 2 == 1:
                midOdd = max(freq[i], midOdd)
            
            if freq[i] > 1:
                if freq[i] %2 == 1:
                    pLength += (freq[i]-1)
                else:
                    pLength += freq[i]
                
        if midOdd != 0:
            pLength += 1
        
        return pLength