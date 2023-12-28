"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from typing import Optional


class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node:
            return None

        clones = {}

        def dfs(node):
            if node in clones:
                return clones[node]

            newNode = Node(node.val)
            clones[node] = newNode

            for n in node.neighbors:
                newNode.neighbors.append(dfs(n))

            return newNode

        return dfs(node)
