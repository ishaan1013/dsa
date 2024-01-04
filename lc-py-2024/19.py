# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        start = ListNode(0, head)
        prev = start
        offset = head

        while n > 0:
            n -= 1
            offset = offset.next

        while offset:
            prev = prev.next
            offset = offset.next

        prev.next = prev.next.next
        return start.next
