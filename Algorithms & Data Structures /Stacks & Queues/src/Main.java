import java.util.Scanner;
import java.util.stream.StreamSupport;

public class Main {

    /*
    Write a method that takes a String argument. The method determines whether the
    parentheses, brackets, and curly braces are balanced in the string, return true if they are
    balanced, false otherwise.
     */

    public static boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        }
        catch (NumberFormatException e) {
            // s is not numeric
            return false;
        }
    }

    public static boolean checkBrackets (String myString){
        Stack<Character> brackets = new Stack<Character>();
        boolean flag = false;
        int numFlags = 0;
        for(int i = 0; i<myString.length();i++){
            char ch2 = myString.charAt(i);
            if(ch2 =='{' || ch2 == '[' || ch2 == '('){
                numFlags++;
            }
        }
        boolean [] flags = new boolean[numFlags];
        for (int i = 0; i<numFlags; i++){
            flags[i] = false;
        }
        int index = 0;
        for (int i = 0; i<myString.length();i++){
            char ch = myString.charAt(i);
            if (ch == '{' || ch == '[' || ch == '(') {
                brackets.push(myString.charAt(i));
            }
            char b;
            if (ch == '}' || ch == ']' || ch == ')'){
                b = brackets.pop();
                if (b == '{') {
                    if (ch == '}'){
                        flag = true;
                        flags[index] = flag;
                        index++;
                    }
                }
                if (b == '[') {
                    if (ch == ']'){
                        flag = true;
                        flags[index] = flag;
                        index++;
                    }
                }
                if (b == '(') {
                    if (ch == ')'){
                        flag = true;
                        flags[index] = flag;
                        index++;
                    }
                }
            }
        }
        for (int i = 0; i< numFlags; i++){
            if (!flags[i]){
                return false;
            }
        }
        return true;
    }

    /*
    Write a method that takes a postfix expression as a String argument. The expression can
    include positive or negative integers and operations ( + , – , * ) separated with white
    spaces. The method should return the result after evaluating the expression. You only need
    to implement the following operations: addition, subtraction, and multiplication.
    o Examples of postfix expressions and their results:
         2 1 +  3
         2 1 + 5 *  15
     */
    public static int postfix (String myString){
        Stack<Integer> oP = new Stack<Integer>();
        String[] elements=myString.split(" ");
        for (int i = 0; i <elements.length; i++){
            if (isNumeric(elements[i])){
                int tmpInt = Integer.parseInt(elements[i]);
                oP.push(tmpInt);
            }else if (elements[i].equals("*") || elements[i].equals("+") || elements[i].equals("-")){
                if (elements [i].equals("*")){
                    int tmp = oP.pop();
                    oP.push((oP.pop()*tmp));
                }else if (elements [i].equals("+")){
                    int tmp = oP.pop();
                    oP.push((oP.pop()+tmp));
                }else if (elements [i].equals("-")){
                    int tmp = oP.pop();
                    oP.push((oP.pop()-tmp));
                }
            }
        }
        return oP.pop();
    }



    public static void main(String[] args) {
        Queue<Integer> testInt = new Queue<Integer>();
        Stack<String> testString = new Stack<String>();
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter your sting with brackts to know if it matches (),{},[]");
        String myString = scnr.nextLine();
        System.out.println(checkBrackets(myString));

        System.out.println("Enter your postfix string with the operations");
        String myString2 = scnr.nextLine();
        System.out.print(postfix(myString2));









        //TEST STACK AND QUEUE
       /* //add elemenrs to the list
        System.out.print("how many elements you wish to add? - QUEUE");
        int ele = scnr.nextInt();
        System.out.println("Enter " + ele + " integers ");
        for (int i = 0; i<ele; i++){
            testInt.enqueue(scnr.nextInt());
        }



        System.out.print("how many elements you wish to add? - STACK  ");
        ele = scnr.nextInt();
        System.out.println("Enter " + ele + " Strings ");
        for (int i = 0; i<ele; i++){
            testString.push(scnr.nextLine());
        }

        System.out.println("Peek 1 "+testString.peek());
        System.out.println("pop "+testString.pop());
        System.out.println("Peek 2 "+testString.peek());*/

    }
}
