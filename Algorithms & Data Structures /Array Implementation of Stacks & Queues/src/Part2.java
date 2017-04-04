/**
 * Created by Roberto on 10/26/16.
 */


public class Part2 {

    public static void main(String [] args){
        int i;
        CircularArrayQueue q=new CircularArrayQueue();
        for (i=0; i<100; i++){
            q.add(i);
        }
        q.add(100);// should print a message, maximum capacity
        q.poll();
        q.add(100);

        for (i=0; i<95; i++){
            q.poll();
        }
        q.print(); // should print 96 97	 98	 99	 100

        q.add(200);
        q.add(300);
        for(i=0; i<7; i++)
            q.poll();

        q.poll(); // should print a message, queue is empty

        for(i=0; i<10; i++)
            q.add(i+1);

        q.print(); //should print the numbers from 1 to 10

    }


}

