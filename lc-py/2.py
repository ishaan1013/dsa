# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        carry = 0
        root = ListNode()
        pos = root
        while l1 or l2 or carry:
            
            if l1:
                n1 = l1.val
            else:
                n1 = 0
                
            if l2:
                n2 = l2.val
            else:
                n2 = 0
                
            v = carry + n1 + n2
            carry = v // 10
            v %= 10
            pos.next = ListNode(v)
            
            pos = pos.next
            if l1:
                l1 = l1.next
            else:
                l1 = None
                
            if l2:
                l2 = l2.next
            else:
                l2 = None
            
        return root.next