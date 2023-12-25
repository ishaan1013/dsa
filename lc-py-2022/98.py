# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        res=[]
        self.search(root, res)
        
        for i in range(1, len(res)):
            if res[i] <= res[i-1]:
                return False
        return True
        
    def search(self, root, res):
        if not root:
            return
        
        self.search(root.left, res)
        res.append(root.val)
        self.search(root.right, res)