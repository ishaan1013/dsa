class Solution {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 == null)
      return list2;
    if (list2 == null)
      return list1;

    ListNode dummy = new ListNode(0);
    ListNode res = dummy;

    while (list1 != null && list2 != null) {
      if (list1.val >= list2.val) {
        res.next = list2;
        list2 = list2.next;
      } else {
        res.next = list1;
        list1 = list1.next;
      }
      res = res.next;
    }
    res.next = list1 == null ? list2 : list1;
    return dummy.next;
  }
}