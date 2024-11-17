package intern_package;

import java.util.Scanner;

public class singly_linked_list {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head = null;

    public void createList(int length, Scanner sc) {
        if (head != null) {
            System.out.println("List already created.");
            return;
        }
        System.out.println("Enter " + length + " elements:");
        for (int i = 0; i < length; i++) {
            int data = sc.nextInt();
            insertAtEnd(data); // Reusing the insertAtEnd method to add elements
        }
        System.out.println("List created with " + length + " elements.");
    }

    public void traverse() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        System.out.print("Linked List: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int search(int key) {
        Node temp = head;
        int position = 0;
        while (temp != null) {
            if (temp.data == key) {
                return position;
            }
            temp = temp.next;
            position++;
        }
        return -1; 
    }

    public int length() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        System.out.println("Element " + data + " inserted at the beginning.");
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Element " + data + " inserted at the end.");
    }

    public void insertAtPosition(int data, int position) {
        if (position < 0 || position > length()) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 0) {
            insertAtBeginning(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        for (int i = 0; i < position - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        System.out.println("Element " + data + " inserted at position " + position);
    }

    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        head = head.next;
        System.out.println("Element deleted from the beginning.");
    }

    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == null) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
        System.out.println("Element deleted from the end.");
    }

    public void deleteAtPosition(int position) {
        if (position < 0 || position >= length()) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 0) {
            deleteFromBeginning();
            return;
        }
        Node temp = head;
        for (int i = 0; i < position - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        System.out.println("Element deleted from position " + position);
    }

    static void execute() {
        singly_linked_list list = new singly_linked_list();
        Scanner sc = new Scanner(System.in);
        int choice, subChoice, element, position;

        do {
            System.out.println("\nMain Menu:");
            System.out.println("1. Create Linked List");
            System.out.println("2. Traverse");
            System.out.println("3. Search");
            System.out.println("4. Length");
            System.out.println("5. Insertion");
            System.out.println("6. Deletion");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
	            case 1:
	                System.out.print("Enter the number of elements for the list: ");
	                int length = sc.nextInt();
	                list.createList(length, sc);
	                break;

                case 2:
                    list.traverse();
                    break;

                case 3:
                    System.out.print("Enter element to search: ");
                    element = sc.nextInt();
                    position = list.search(element);
                    if (position == -1) {
                        System.out.println("Element not found.");
                    } else {
                        System.out.println("Element found at position: " + position);
                    }
                    break;

                case 4:
                    System.out.println("Length of the list: " + list.length());
                    break;

                case 5:
                    System.out.println("Insertion Menu:");
                    System.out.println("1. Insert at Beginning");
                    System.out.println("2. Insert at End");
                    System.out.println("3. Insert at Specific Position");
                    System.out.print("Enter your choice: ");
                    subChoice = sc.nextInt();

                    System.out.print("Enter element to insert: ");
                    element = sc.nextInt();

                    switch (subChoice) {
                        case 1:
                            list.insertAtBeginning(element);
                            break;
                        case 2:
                            list.insertAtEnd(element);
                            break;
                        case 3:
                            System.out.print("Enter position to insert at: ");
                            position = sc.nextInt();
                            list.insertAtPosition(element, position);
                            break;
                        default:
                            System.out.println("Invalid insertion choice.");
                    }
                    break;

                case 6:
                    System.out.println("Deletion Menu:");
                    System.out.println("1. Delete from Beginning");
                    System.out.println("2. Delete from End");
                    System.out.println("3. Delete Specific Position");
                    System.out.print("Enter your choice: ");
                    subChoice = sc.nextInt();

                    switch (subChoice) {
                        case 1:
                            list.deleteFromBeginning();
                            break;
                        case 2:
                            list.deleteFromEnd();
                            break;
                        case 3:
                            System.out.print("Enter position to delete: ");
                            position = sc.nextInt();
                            list.deleteAtPosition(position);
                            break;
                        default:
                            System.out.println("Invalid deletion choice.");
                    }
                    break;

                case 7:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 7);

        sc.close();
    }
}
