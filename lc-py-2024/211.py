class Node:
    def __init__(self):
        self.children = {}
        self.terminal = False


class WordDictionary:
    def __init__(self):
        self.node = Node()

    def addWord(self, word: str) -> None:
        node = self.node

        for c in word:
            if c not in node.children:
                node.children[c] = Node()
            node = node.children[c]
        node.terminal = True

    def search(self, word: str) -> bool:

        def searchWithNode(pos, start):
            node = start

            for i in range(pos, len(word)):
                c = word[i]
                if c == ".":
                    for child in node.children.values():
                        if searchWithNode(i + 1, child):
                            return True
                    return False
                else:
                    if c not in node.children:
                        return False
                    node = node.children[c]

            return node.terminal

        return searchWithNode(0, self.node)

# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)
