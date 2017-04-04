/**
 * Created by Roberto on 10/26/16.
 */
/**
 * Created by Roberto on 10/26/16.
 */
public class CircularArrayQueue {
    private int data[];
    private int capacity=100; //maximum capacity for this queue
    private int front; //index of front of queue
    private int back; // index of back of queue
    private int length;

    //constructor
    public CircularArrayQueue(){
        data=new int[capacity];
        front=0;
        back=0;
        length=0;
    }

    //add an item to the queue
    public void add(int value){
        //add to the back
        if (front == back+1 || back - front == capacity -1) {  //check if the queue is full
            System.out.println("reached maximum capacity");
        }else {
            data[back] = value;
            back = (back +1) % capacity;
        }

    }


    public boolean isEmpty(){
        return (front == back);
    }

    //print the values of the queue
    public void print(){
        if (isEmpty()){
            System.out.println("Queue is Empty!");
        }else if (back < front){
            for (int i = front; i < capacity-1; i++) {
                System.out.println(data[i]);
            }
            for (int i = 0; i <= back-1; i++) {
                System.out.println(data[i]);
            }
        }else if (front == back) {
        for (int i = front; i <= back-1; i++) {
            System.out.println(data[i]);
        }
    }
        for (int i=front; i<back;i++){
            System.out.print(data[i]+"\t");
        }
        System.out.println();
    }

    public int poll(){
        if (isEmpty()){
            System.out.println("The queue is empty");
            return -1;
        }else{
            int item = data[front]; //get the value of the front element //increment front index
            front = (front +1)  % capacity;
            return item;
        }

    }
    public int peek(){
        return data[front];
    }

}


