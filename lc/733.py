class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        self.fill(image, sr, sc, color, image[sr][sc])
        
        return image
    
    def fill(self, image, sr, sc, color, start):
        #start is the original colour of [sr][sc]
        
        if image[sr][sc] != start or image[sr][sc] == color:
            return
        
        image[sr][sc] = color
        
        if sr > 0:
            self.fill(image, sr-1, sc, color, start)
        if sr < len(image)-1:
            self.fill(image, sr+1, sc, color, start)
        if sc > 0:
            self.fill(image, sr, sc-1, color, start)
        if sc < len(image[0])-1:
            self.fill(image, sr, sc+1, color, start)