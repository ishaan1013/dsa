class Solution {
  public ListNode reverseList(ListNode head) {
    return reverser(head, null);
  }

  private ListNode reverser(ListNode h, ListNode nH) {
    if (h == null) {
      return nH;
    }
    ListNode next = h.next;
    h.next = nH;
    return reverser(next, h);
  }
}