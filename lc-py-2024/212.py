class Node:
    def __init__(self):
        self.children = {}
        self.terminal = False
        self.occurences = 0

    def insert(self, word: str) -> None:
        node = self
        node.occurences += 1

        for c in word:
            if c not in node.children:
                node.children[c] = Node()
            node = node.children[c]
            node.occurences += 1
        node.terminal = True

    def remove(self, word):
        node = self
        node.occurences -= 1

        for c in word:
            if c in node.children:
                node = node.children[c]
                node.occurences -= 1


class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        m, n = len(board), len(board[0])
        res, visited = set(), set()

        trie = Node()
        for word in words:
            trie.insert(word)

        def dfs(x, y, node, word):
            if x < 0 or x >= m or y < 0 or y >= n or (x, y) in visited:
                return

            if board[x][y] not in node.children or node.children[board[x][y]].occurences < 1:
                return

            visited.add((x, y))

            newNode = node.children[board[x][y]]
            word += board[x][y]
            if newNode.terminal:
                newNode.terminal = False
                res.add(word)
                trie.remove(word)

            dfs(x-1, y, newNode, word)
            dfs(x+1, y, newNode, word)
            dfs(x, y-1, newNode, word)
            dfs(x, y+1, newNode, word)

            visited.remove((x, y))

        for i in range(m):
            for j in range(n):
                dfs(i, j, trie, "")

        return res
