/**
 * Created by Roberto on 10/26/16.
 */
public class ArrayStack {
    private int data[];
    private int capacity=100; //maximum capacity for this queue
    private int front; //index of front of queue
    private int back; // index of back of queue
    private int length;

    //constructor
    public ArrayStack(){
        data=new int[capacity];
        front=0;
        back=0;
        length=0;
    }

    //add an item to the queue
    public void push(int value){
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

    public int pop(){
        if (isEmpty()){
            return -1;
        }else{
            int item = data[back-1]; //get the value of the front element //increment front index
            back--;
            return item;
        }

    }
    public int peek(){
        return data[back-1];
    }
}
