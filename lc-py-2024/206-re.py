# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:

    def reverser(self, head, reverse):
        if not head:
            return reverse

        next = head.next

        head.next = reverse
        reverse = head

        return self.reverser(next, reverse)

    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:

        return self.reverser(head, None)
