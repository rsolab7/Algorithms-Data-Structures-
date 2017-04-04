/**
 * Created by Roberto on 10/19/16.
 */
public class Queue <T>{
    private ListNode<T> head;
    private ListNode<T> tail;

    public Queue(){
        //empty linked list
        head=null;
        tail=null;
    }

    public void enqueue(T value){
        //if list is empty
        if (head==null){
            head=new ListNode<T>(value);
            tail=head;
        }else{
            //create new Node
            ListNode <T> newNode = new ListNode <T> (value);
            //set previous link to the last element (tail)
            newNode.setPrevious(tail);
            //link the tail of the list to the new node
            tail.setNext(newNode);
            //update tail - new node is the new list tail
            tail=newNode;
        }
    }
    public boolean isEmpty(){
        if (head == null)
            return true;
        else return false;
    }

    public T dequeue() {
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
