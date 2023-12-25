class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        if len(strs)==0:
            return [[""]]
        
        wordMap={}
        
        for i in strs:
            sort = "".join(sorted(i))
            
            if sort in wordMap:
                wordMap[sort].append(i)
            else:
                wordMap[sort] = [i]
                
        return wordMap.values()