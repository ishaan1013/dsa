class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        n = len(matrix)

        for x in range((n+1)//2):
            top = n-x-1
            base = 0 + x
            for i in range(top - 2 * x):
                start = i + x
                rev = top - i
                temp = matrix[base][start]
                matrix[base][start] = matrix[rev][base]
                matrix[rev][base] = matrix[top][rev]
                matrix[top][rev] = matrix[start][top]
                matrix[start][top] = temp
