import java.util.Scanner;

public class Main extends ReversePolishNotation {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.print("Please enter a String in standard infix notation, REMEMBER TO USE WHITESPACES IN BETWEEN CHARACTERS ");
        System.out.println("Ex: ( 1 + 2 ) * ( 3 / 4 ) ^ ( 5 + 6 )");
        String myString = scnr.nextLine();
        String[] input =myString.split(" ");
        String[] output = infixToRPN(input);
        for (String token : output) {
            System.out.print(token + " ");
        }
    }
}
