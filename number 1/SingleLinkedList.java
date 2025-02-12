class Node {
  int data;
  Node next;

  Node(int data) {
    this.data = data;
    this.next = null;
  }
}

class SingleLinkedList {
  Node head;

  public void insertAtEnd(int data) {
    Node newNode = new Node(data);
    if (head == null) {
      head = newNode;
      return;
    }
    Node current = head;
    while (current.next != null) {
      current = current.next;
    }
    current.next = newNode;
  }

  public void insertAtBeginning(int data) {
    Node newNode = new Node(data);
    newNode.next = head;
    head = newNode;
  }

  public void deleteByValue(int data) {
    if (head == null)
      return;

    if (head.data == data) {
      head = head.next;
      return;
    }

    Node current = head;
    while (current.next != null) {
      if (current.next.data == data) {
        current.next = current.next.next;
        return;
      }
      current = current.next;
    }
  }

  public void display() {
    Node current = head;
    while (current != null) {
      System.out.print(current.data + " -> ");
      current = current.next;
    }
    System.out.println("null");
  }

  public static void main(String[] args) {
    SingleLinkedList list = new SingleLinkedList();

    list.insertAtEnd(10);
    list.insertAtEnd(20);
    list.insertAtEnd(30);

    System.out.println("After inserting at the end:");
    list.display();

    list.insertAtBeginning(5);
    list.insertAtBeginning(1);

    System.out.println("After inserting at the beginning:");
    list.display();

    list.deleteByValue(20);
    System.out.println("After deleting 20:");
    list.display();

    list.deleteByValue(1);
    System.out.println("After deleting 1:");
    list.display();
  }
}