# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        if not head:
            return
        # head doesn't end up getting modified; slow & fast themselves are being reassigned, not their attributes
        slow, fast = head, head

        while fast.next and fast.next.next:
            slow = slow.next  # middle
            fast = fast.next.next

        rHalf = slow.next
        rev = slow.next = None
        while rHalf:
            next = rHalf.next
            rHalf.next = rev
            rev = rHalf
            rHalf = next

        # this DOES modify head because left.next is modified first (attribute), so head's attribute follows
        left, right = head, rev
        while right:
            next1, next2 = left.next, right.next
            left.next = right
            right.next = next1
            left, right = next1, next2
