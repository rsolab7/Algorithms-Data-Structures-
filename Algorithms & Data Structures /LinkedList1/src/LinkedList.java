/**
 * Created by Roberto on 9/8/16.
 */
public class LinkedList {
    //private variables:
    private IntNode head;
    private IntNode tail;

    //constructor
    public LinkedList(){
        //empty linked list
        head=null;
        tail=null;
    }

    //add a node to the list
    public void add(int value){
        //if list is empty
        if (head==null){
            head=new IntNode(value);
            tail=head;
        }else{
            //create new Node
            IntNode newNode=new IntNode(value);
            //set previous link to the last element (tail)
            newNode.setPrevious(tail);
            //link the tail of the list to the new node
            tail.setNext(newNode);
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
        //start from the head node
        IntNode currentNode=head;
        while(currentNode !=null){
            //print the value of the current node
            System.out.print(currentNode.getData() +"\t");
            //go to the next node
            currentNode=currentNode.getNext();
        }
        System.out.println();
    }

    public void addFirst (int value ){
        IntNode newnode2 = new IntNode(value);  //create a new IntNode
        if (isEmpty()){
            head = newnode2;
            tail =newnode2;
        }else {
            newnode2.setNext(head); //set the next node
            head.setPrevious(newnode2); //set the previous node of the head element
            head = newnode2;    //update head
        }
    }

    public void deleteFirst(){
        if (isEmpty()){
            return;
        }else if(head == tail){
            head = null;
            tail = null;
        }else {
            head.getNext().setPrevious(null);
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
            tail.getPrevious().setNext(null);
            tail = tail.getPrevious();
        }
    }

    public void deleteValue(int k){
        if (isEmpty()){
            return;
        }
        IntNode currentNode = head;
        while (currentNode != null) {
            //If current node is in between two nodes
            if (currentNode.getData() == k){
                //if its firts node
                if(currentNode == head){
                    deleteFirst();
                    //if its the last node
                }else if (currentNode == tail ){
                    deleteLast();
                    //if its middle node
                } else{
                    currentNode.getPrevious().setNext(currentNode.getNext());
                    currentNode.getNext().setPrevious(currentNode.getPrevious());
                }
            }
            currentNode= currentNode.getNext();
        }

    }

}
