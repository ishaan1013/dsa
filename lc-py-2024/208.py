class Node:
    def __init__(self):
        self.children = {}
        self.terminal = False


class Trie:

    def __init__(self):
        self.node = Node()

    def insert(self, word: str) -> None:
        node = self.node

        for c in word:
            if c not in node.children:
                node.children[c] = Node()
            node = node.children[c]
        node.terminal = True

    def search(self, word: str) -> bool:
        node = self.node

        for c in word:
            if c not in node.children:
                return False
            node = node.children[c]

        if node.terminal:
            return True

    def startsWith(self, prefix: str) -> bool:
        node = self.node

        for c in prefix:
            if c not in node.children:
                return False
            node = node.children[c]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
