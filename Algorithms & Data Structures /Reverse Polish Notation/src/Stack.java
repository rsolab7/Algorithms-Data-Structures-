/**
 * Created by Roberto on 10/24/16.
 */
public class Stack<T> {
    private ListNode<T> head;
    private ListNode<T> tail;
    public Stack(){
        //empty linked list
        head=null;
        tail=null;
    }
    public boolean isEmpty(){
        if (head == null)
            return true;
        else return false;
    }

    public void push (T value){
        ListNode<T> newnode2 = new ListNode<T>(value);  //create a new IntNode
        if (isEmpty()){
            head = newnode2;
            tail = newnode2;
            head.setNext(head);
        }else {
            newnode2.setNext(head); //set the next node
            head = newnode2;    //update head
            tail.setNext(null);
        }
    }



    public T pop() {
        T tmp;
        if (isEmpty()){
            return null;
        }else if(head == tail){
            tmp = head.getData();
            head = null;
            tail = null;
            return tmp;
        }else {
            tmp = head.getData();
            head = head.getNext();
            return tmp;
        }
    }

    public T peek(){
        return head.getData();
    }


}

