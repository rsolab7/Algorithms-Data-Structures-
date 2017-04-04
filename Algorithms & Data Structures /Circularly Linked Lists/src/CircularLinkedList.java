/**A basic implementation of a circular singly linked list
 CSCI 1112 Fall 2016
 The George Washington University
 **/
import java.util.*;

public class CircularLinkedList {
    public static void main(String[] args){
        CircularLinkedList test = new CircularLinkedList();
        Scanner scnr = new Scanner(System.in);
        boolean p = false;

        System.out.println("This program is intended to desmotrate the different uses of linklists, please us the char 'y' when you wish to proceed  ");


        //add elemenrs to the list
        System.out.print("how many elements you wish to add? ");
        int ele = scnr.nextInt();
        System.out.println("Enter " + ele + " integers ");
        for (int i = 0; i<ele; i++){
            test.add(scnr.nextInt());
        }
        System.out.println("Initial list:");
        test.print();

        System.out.print("Do you wish to delete the first value of the list? ");
        scnr.nextLine();
        if(scnr.nextLine().toLowerCase().equals("y")) {
            test.deleteFirst();
            p = true;
        }
        System.out.print("Do you wish to delete the last value of the list? ");
        if(scnr.nextLine().toLowerCase().equals("y")) {
            test.deleteLast();
            p = true;
        }
        if (p) {
            System.out.println("Print list with deleted values: ");
            test.print();
        }


        System.out.print("Do you wish to add a new value at the beguinning of the list? ");
        if(scnr.nextLine().toLowerCase().equals("y")) {
            System.out.print("Add the new first value of the list: ");
            test.addFirst(scnr.nextInt());
            test.print();
        }

        System.out.print("Do you wish to delete a value of the list? ");
        //scnr.nextLine();
        if(scnr.nextLine().toLowerCase().equals("y")) {
            System.out.print("Which value you whish to delete? ");
            test.deleteValue(scnr.nextInt());
            test.print();
        }



    }

    //private variables:
    private IntNode head;
    private IntNode tail;

    //constructor
    public CircularLinkedList(){
        //empty linked list
        head=null;
        tail=null;
    }

    //add a node to the end of the list
    public void add(int value){
        //create new Node
        IntNode newNode=new IntNode(value);
        //if list is empty
        if (isEmpty()){
            //set new node as head
            head=newNode;
            //set next link to the head
            newNode.setNext(head);
            //set tail as the head
            tail=head;
        }else{
            //set next link of the tail to the new node
            tail.setNext(newNode);
            //set next link of the new node to the head
            newNode.setNext(head);
            //update tail - new node is the new list tail
            tail=newNode;
        }
    }


    //check if linked list is empty
    public boolean isEmpty(){
        if (head ==null)
            return true;
        else return false;
    }

    //print the values in the linked list
    public void print(){
        //if list is empty
        if(isEmpty()){
            System.out.println("empty\n");
            return;
        }
        //if list has one node
        if (head.getNext() == head)
        {
            System.out.println(head.getData());
            return;
        }
        //start from the head node
        IntNode currentNode=head;

        while(currentNode.getNext() != head){
            //print the value of the current node
            System.out.print(currentNode.getData() +"\t");
            //go to the next node
            currentNode=currentNode.getNext();
        }
        System.out.print(currentNode.getData());
        System.out.println();
    }

    public void addFirst (int value ){
        IntNode newnode2 = new IntNode(value);  //create a new IntNode
        //FIXME
        if (isEmpty()){
            head = newnode2;
            tail = newnode2;
            head.setNext(head);
            //tail.setNext(tail);
        }else {
            newnode2.setNext(head); //set the next node
            head = newnode2;    //update head
            tail.setNext(newnode2);
        }
    }

    public void deleteFirst(){
        if (isEmpty()){
            return;
        }else if(head == tail){
            head = null;
            tail = null;
        }else {
            //head.getNext().setPrevious(null);
            //head = head.getNext();
            tail.setNext(head.getNext());
            head = head.getNext();
        }
    }

    public void deleteLast(){
        if (isEmpty()){
            return;
        }else if(head == tail){
            head = null;
            tail = null;
        }else {
            IntNode currentNode = head;
            while (currentNode.getNext() != tail){ //FIXME
                //go to the next node
                currentNode=currentNode.getNext();
            }
            currentNode.setNext(head);
            tail = currentNode;
        }
    }

    public void deleteValue(int k){
        if (isEmpty()){
            return;
        }
        IntNode currentNode = head;
        while (currentNode.getNext() != head) {
            //If current node is in between two nodes
            if (currentNode.getData() == k){
                //if its firts node
                if(currentNode == head){
                    deleteFirst();
                    //if its the last node
                } else{
                    IntNode currentNode2 = head;
                    while (currentNode2.getNext() != currentNode){
                        //go to the next node
                        currentNode2=currentNode2.getNext();
                    }
                    currentNode2.setNext(currentNode.getNext());
                }
            }
            currentNode = currentNode.getNext();
        }
        if (currentNode.getData() == k ) {
            deleteLast();
        }

    }



}