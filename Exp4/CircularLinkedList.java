package Exp4;
class CircularNode {
    int data;
    CircularNode next;
    CircularNode(int d) {
        data = d;
        next = null;
    }
}

class CircularLinkedList {
    CircularNode head;

    void insertAtBeginning(int x) {
        CircularNode newNode = new CircularNode(x);
        if (head == null) {
            newNode.next = newNode;
            head = newNode;
            return;
        }
        CircularNode temp = head;
        while (temp.next != head) temp = temp.next;
        newNode.next = head;
        temp.next = newNode;
        head = newNode;
    }

    void insertAtEnd(int x) {
        CircularNode newNode = new CircularNode(x);
        if (head == null) {
            newNode.next = newNode;
            head = newNode;
            return;
        }
        CircularNode temp = head;
        while (temp.next != head) temp = temp.next;
        temp.next = newNode;
        newNode.next = head;
    }

    void deleteAtBeginning() {
        if (head == null) return;
        if (head.next == head) {
            head = null;
            return;
        }
        CircularNode temp = head, last = head;
        while (last.next != head) last = last.next;
        head = head.next;
        last.next = head;
    }

    void deleteAtEnd() {
        if (head == null) return;
        if (head.next == head) {
            head = null;
            return;
        }
        CircularNode temp = head;
        while (temp.next.next != head) temp = temp.next;
        temp.next = head;
    }

    void display() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        CircularNode temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.insertAtBeginning(10);
        cll.insertAtEnd(20);
        cll.insertAtBeginning(5);
        cll.insertAtEnd(30);

        System.out.print("CLL: ");
        cll.display();

        cll.deleteAtBeginning();
        cll.deleteAtEnd();

        System.out.print("After Deletion: ");
        cll.display();
    }
}
