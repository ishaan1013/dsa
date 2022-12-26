# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        out=[]
        
        q = collections.deque()
        q.append(root)
        
        while q:
            lvl = []
            for i in range(len(q)):
                item = q.popleft()
                if item:
                    lvl.append(item.val)
                    q.append(item.left)
                    q.append(item.right)
            if lvl:
                out.append(lvl)
            
        return out