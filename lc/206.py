# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        #p contains the previous numbers of the list, in reverse order
        #c is the current linked list, removing the first node each time through the loop
        p, c = None,head
        while c:
            c.next, p, c = p, c, c.next
        return p