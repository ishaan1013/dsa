class Solution:
    def getHint(self, secret: str, guess: str) -> str:
        a=0
        for x, y in zip(secret, guess):
            a += (x==y)
            
        b = sum((Counter(secret) & Counter(guess)).values())
        b -= a
        
        return str(a)+"A"+str(b)+"B"