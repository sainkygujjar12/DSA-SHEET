package LinkedList;

public class reverseLL {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original List:");
        printList(head);

        head = reverseList(head);

        System.out.println("Reversed List:");
        printList(head);
    }

    public static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next; // Store next node
            current.next = prev;          // Reverse current node's pointer
            prev = current;               // Move prev to current
            current = nextNode;           // Move to next node
        }
        return prev; // New head of the reversed list
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }   
}
