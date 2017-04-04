public class Main {

    public static void main(String[] args) {
        ArrayStack myStack = new ArrayStack();
        ArrayQueue myQueue = new ArrayQueue();

        myStack.push(1); myStack.push(2); myStack.push(3);
        myQueue.add(9); myQueue.add(8); myQueue.add(7);

        System.out.print("The stack is: ");
        myStack.print();
        System.out.print("The queue is: ");
        myQueue.print();

        System.out.println("The first value of the Stack is: "+ myStack.peek());
        System.out.println("The first value of the queue is: "+ myQueue.peek());

        System.out.println("Lets remove the first values");
        System.out.println("vale removed in stack is "+ myStack.pop());
        System.out.println("vale removed in queue is "+ myQueue.poll());


        System.out.println("Now the stack and queue are: ");
        System.out.print("The stack is: ");
        myStack.print();
        System.out.print("The queue is: ");
        myQueue.print();
    }
}
