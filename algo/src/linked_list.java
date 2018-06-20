import java.util.Arrays;
import java.util.List;

public class linked_list {

  public ListNode detectCycle(ListNode head) {
    ListNode fast, slow;
    if (head == null) {
      return null;
    }
    fast = slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        slow = head;
        while (fast != slow) {
          fast = fast.next;
          slow = slow.next;
        }
        return fast;
      }
    }

    return null;
  }


  public static void main(String[] args) {
    linked_list test = new linked_list();

    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = head;
    System.out.println(test.detectCycle(head));
    System.out.println(head);

  }
}


class ListNode {

  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }

  @Override
  public String toString() {
    return String.format("[%s] %d", super.toString(), val);
  }
}




