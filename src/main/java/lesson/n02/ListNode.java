package lesson.n02;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ListNode {
  private int val;

  private ListNode next;

  public ListNode() { }

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public static ListNode reverseList(ListNode head) {
    if (head == null) {
        return null;
    }

    ListNode current = new ListNode(head.getVal());

    if (head.getNext() == null) {
        return current;
    }

    ListNode reverse = reverseList(head.getNext());

    if (reverse.getNext() == null) {
        reverse.setNext(current);
        return reverse;
    }

    ListNode last = reverse.getNext();
    while (last.getNext() != null) {
        last = last.getNext();
    }
    last.setNext(current);

    return reverse;
    }

    public static void print(ListNode head) {
      if (head == null) {
        return;
      }
      System.out.println(head.val);
      print(head.next);
    }

    public static void main(String[] args) {
      ListNode node1 = new ListNode(1);
      ListNode node2 = new ListNode(2, node1);
      ListNode node3 = new ListNode(3, node2);

      System.out.println("Before:");
      print(node3);

      ListNode reverse = reverseList(node3);

      System.out.println("After:");
      print(reverse);
    }
}
