# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        if not root:
            return False
        if not subRoot:
            return True

        def equal(node1, node2):
            if not (node1 or node2):
                return True

            if node1 and node2:
                if node1.val == node2.val:
                    return equal(node1.left, node2.left) and equal(node1.right, node2.right)
            return False

        if equal(root, subRoot):
            return True
        return self.isSubtree(root.left, subRoot) or self.isSubtree(root.right, subRoot)
