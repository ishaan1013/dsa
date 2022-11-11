class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        row=[1]*n
        
        for i in range(m-1):
            row2=[1]*n
            for x  in range(n-2, -1, -1):
                row2[x]=row2[x+1]+row[x]
            row=row2
             
        return row[0]