package Seminar_3.Reverse_Singled_Linked_List;

class Answer {
    Node head;
    public void reverse() {
        Node current = head;
        Node previous = null;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }
}
