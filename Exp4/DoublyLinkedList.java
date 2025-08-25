package Exp4;

class DoublyNode {
    int data;
    DoublyNode prev, next;
    DoublyNode(int d) {
        data = d;
        prev = next = null;
    }
}

class DoublyLinkedList {
    DoublyNode head;

    void insertAtBeginning(int x) {
        DoublyNode newNode = new DoublyNode(x);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
    }

    void insertAtEnd(int x) {
        DoublyNode newNode = new DoublyNode(x);
        if (head == null) {
            head = newNode;
            return;
        }
        DoublyNode temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
    }

    void deleteAtBeginning() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
            return;
        }
        head = head.next;
        head.prev = null;
    }

    void deleteAtEnd() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
            return;
        }
        DoublyNode temp = head;
        while (temp.next != null) temp = temp.next;
        temp.prev.next = null;
    }

    void display() {
        DoublyNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAtBeginning(10);
        dll.insertAtEnd(20);
        dll.insertAtBeginning(5);
        dll.insertAtEnd(30);

        System.out.print("DLL: ");
        dll.display();

        dll.deleteAtBeginning();
        dll.deleteAtEnd();

        System.out.print("After Deletion: ");
        dll.display();
    }
}
