/**
 * Created by Roberto on 10/19/16.
 */
public class ListNode<T> {
    private T data;
    private ListNode<T> next;
    private ListNode<T> previous;

    //constructor
    public ListNode(T value){
        data=value;
        next=null;
        previous=null;
    }

    //set data value
    public void setData(T value){
        data=value;
    }
    //set link to next node
    public void setNext(ListNode node){
        next=node;
    }
    //set link to previous node
    public void setPrevious(ListNode node){
        previous=node;
    }
    //return the data value
    public T getData(){
        return data;
    }
    //return the next node
    public ListNode getNext(){
        return next;
    }
    //return the previous node
    public ListNode getPrevious(){
        return previous;
    }
}
