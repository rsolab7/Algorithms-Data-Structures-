/**A basic implementation of a circular singly linked list
 CSCI 1112 Fall 2016
 The George Washington University
 **/
import java.util.*;

class CircularLinkedList {

    //private variables:
    private IntNode head;
    private IntNode tail;


    //constructor
    public CircularLinkedList(){
        //empty linked list
        head=null;
        tail=null;
    }

    public IntNode returnHead (){
        return head;
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
            newNode.setNext(null);
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
           // System.out.println("empty\n");
            return;
        }
        //if list has one node
        if (head.getNext() == null)
        {
            System.out.println(head.getData());
            return;
        }
        //start from the head node
        IntNode currentNode=head;

        while(currentNode.getNext() != null){
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
            head.setNext(null);
            //tail.setNext(tail);
        }else {
            newnode2.setNext(head); //set the next node
            head = newnode2;    //update head
            tail.setNext(null);
        }
    }
    public void addLast(int value) {
        IntNode newnode = new IntNode(value);
        newnode.setNext(null);
        tail.setNext(newnode);
        tail = newnode;
    }


    public static IntNode sortLinkedList (IntNode head){
        int numComparisons = 0;
        int comparisonlist = 0;
        if (head == null || head.getNext() == null ) return head;
        IntNode dummyhead = new IntNode(0), p = head;
        dummyhead.setNext(head);
        while (p.getNext() != null) {
            if (p.getData() <= p.getNext().getData()) {
                p = p.getNext();
                comparisonlist++;
            } else {
                IntNode temp = p.getNext(), q = dummyhead;
                p.setNext(p.getNext().getNext());
                while (q.getNext().getData() < temp.getData()) {
                    comparisonlist++;
                    q = q.getNext();
                }
                temp.setNext(q.getNext());
                q.setNext(temp);
            }
        }
        numComparisons = numComparisons + comparisonlist;
        System.out.println("The average number of comparisons performed in the linked lisk were: " + numComparisons);
        return dummyhead.getNext();
    }


}