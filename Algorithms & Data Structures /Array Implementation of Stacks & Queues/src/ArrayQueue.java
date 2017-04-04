/**
 * Created by Roberto on 10/26/16.
 */
public class ArrayQueue {
    private int data[];
    private int capacity=100; //maximum capacity for this queue
    private int front; //index of front of queue
    private int back; // index of back of queue
    private int length;

    //constructor
    public ArrayQueue(){
        data=new int[capacity];
        front=0;
        back=0;
        length=0;
    }

    //add an item to the queue
    public void add(int value){
        //add to the back
        if(back<capacity){
            data[back]=value;
            back++;
            length++;
        }else{
            System.out.println("reached maximum capacity");
        }
    }


    public boolean isEmpty(){
        return (length==0);
    }

    //print the values of the queue
    public void print(){
        for (int i=front; i<back;i++){
            System.out.print(data[i]+"\t");
        }
        System.out.println();
    }

    public int poll(){
        if (isEmpty()){
            return -1;
        }else{
            int item = data[front]; //get the value of the front element //increment front index
            front++;
            return item;
        }

    }
    public int peek(){
        return data[front];
    }

}

