package intern_package;

import java.util.Scanner; 

public class list_application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose the feature to implement:");
        System.out.println("1. Arrays");
        System.out.println("2. Singly Linked List");
        System.out.println("3. Doubly Linked List");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                arrays arrays = new arrays();
                arrays.execute();
                break;
            case 2:
                singly_linked_list singlyLinkedList = new singly_linked_list();
                singlyLinkedList.execute();
                break;
            case 3:
                doubly_linked_list doublyLinkedList = new doubly_linked_list();
                doublyLinkedList.execute(); 
                break;
            default:
                System.out.println("Invalid choice. Please choose a valid feature.");
        }

        scanner.close();
    }
}
