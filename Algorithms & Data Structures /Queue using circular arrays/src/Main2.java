import java.util.Scanner;

/**
 * Created by Roberto on 10/27/16.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        CircularArrayQueue myArray = new CircularArrayQueue();
       /* TEST THE IMPLEMENTATION OF THE QUEUE
        myArray.add(1);
        myArray.add(2);
        myArray.add(2);
        System.out.print(" "+myArray.poll());
        System.out.print(" "+myArray.poll());
        System.out.print(" "+myArray.poll());
        */
        System.out.print("Enter enter Enigma's key: ");
        String myKey = scnr.nextLine();
        myKey = myKey.toLowerCase();
        System.out.print("Enter the message that will be inputed into Enigma and sent to Hitler: ");
        String myEnigma = scnr.nextLine();
        myEnigma = myEnigma.toLowerCase();
        char [] myCharEnigman = new char[myEnigma.length()];
        char [] myKeyArray = new char[myKey.length()];
        for (int i = 0; i< myEnigma.length(); i++){
            myCharEnigman[i] = myEnigma.charAt(i);
            //System.out.print(myCharEnigman[i]);
        }
        for (int i = 0; i< myKey.length(); i++){
            myKeyArray[i] = myKey.charAt(i);
            myArray.add(myKeyArray[i]);
        }
        char tmp;
        for (int i = 0; i<myEnigma.length(); i++){
            tmp = (char) (myArray.poll());
            myCharEnigman[i]= (char) (((myCharEnigman[i] - 97 + tmp )% 26)+97);
            myArray.add(tmp);
        }

        for (int i = 0; i<myCharEnigman.length; i++){
            System.out.print(myCharEnigman[i]+" ");
        }




    }
}
