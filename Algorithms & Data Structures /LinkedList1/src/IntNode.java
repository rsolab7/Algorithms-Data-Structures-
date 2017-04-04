/**
 * Created by Roberto on 9/8/16.
 */
public class IntNode {
    private int data;
    private IntNode next;
    private IntNode previous;

    //constructor
    public IntNode(int value){
        data=value;
        next=null;
        previous=null;
    }

    //set data value
    public void setData(int value){
        data=value;
    }
    //set link to next node
    public void setNext(IntNode node){
        next=node;
    }
    //set link to previous node
    public void setPrevious(IntNode node){
        previous=node;
    }
    //return the data value
    public int getData(){
        return data;
    }
    //return the next node
    public IntNode getNext(){
        return next;
    }
    //return the previous node
    public IntNode getPrevious(){
        return previous;
    }
}
