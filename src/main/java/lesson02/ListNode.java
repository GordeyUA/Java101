package lesson02;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode reverseList(ListNode head) {
        if (head == null)
            return null;

        ListNode current = new ListNode(head.val);

        if (head.next == null)
            return current;

        ListNode reverse = reverseList(head.next);

        if (reverse.next == null) {
            reverse.next = current;
            return reverse;
        }

        ListNode last = reverse.next;
        while (last.next != null)
            last = last.next;
        last.next = current;

        return reverse;
    }

    public static void print(ListNode head) {
        if (head == null)
            return;
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
