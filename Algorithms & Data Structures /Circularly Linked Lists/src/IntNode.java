/**A basic implementation of a circular singly linked list Node
 CSCI 1112 Fall 2016
 The George Washington University
 **/

public class IntNode {
    private int data;
    private IntNode next;

    //constructor
    public IntNode(int value){
        data=value;
        next=null;
    }

    //set data value
    public void setData(int value){
        data=value;
    }
    //set link to next node
    public void setNext(IntNode node){
        next=node;
    }
    //return the data value
    public int getData(){
        return data;
    }
    //return the next node
    public IntNode getNext(){
        return next;
    }
}