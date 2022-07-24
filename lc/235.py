# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        pos = root

        while True:
            if p.val < pos.val and q.val < pos.val:
                pos = pos.left
            elif p.val > pos.val and q.val > pos.val:
                pos = pos.right
            else:
                return pos