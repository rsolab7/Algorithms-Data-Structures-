/**
 * Created by Roberto on 9/8/16.
 */
import java.util.Scanner;

public class mainLinkListsLab {
    public static void main(String[] args) {
        LinkedList test = new LinkedList();
        Scanner scnr = new Scanner(System.in);
        System.out.print("how many elements you wish to add? ");
        int ele = scnr.nextInt();

        for (int i = 0; i<ele; i++){
            test.add(scnr.nextInt());
        }
        System.out.println("Initial list:");
        test.print();

        System.out.println("Test, deleting first value ");
        test.deleteFirst();
        System.out.println("Test, deleting last value ");
        test.deleteLast();

        System.out.println("Printing list with new deleted values: ");
        test.print();

        System.out.print("Add the new first value of the list: ");
        test.addFirst(scnr.nextInt());
        test.print();


        System.out.print("Which other value you whish to delete");
        test.deleteValue(scnr.nextInt());
        test.print();
    }
}
