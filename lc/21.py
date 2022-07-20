# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        root = pos = ListNode()
        while list1 and list2:
                
            if list1.val > list2.val:
                pos.next = ListNode(list2.val)
                list2 = list2.next
            else:
                pos.next = ListNode(list1.val)
                list1 = list1.next
                
            pos = pos.next
            
        if list1:
            pos.next = list1
        if list2:
            pos.next = list2
                
        return root.next
    
