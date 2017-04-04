import java.util.Scanner;

public class Main {

    //n must be non negative
    public static double sumover(int n){
        double sum = 0;
        double reciprocal =0;
        for (double i = 1; i <= n; i++){
             reciprocal = 1/i;
            sum = sum + reciprocal;
        }
        return  sum;
    }

    // 5 calls 4, 4 colls 3... 0 stops
    public static double recursiveSumover(double n){
        if (n==0) {
            return 0;
        }else {
            return (1/n + recursiveSumover(n-1));
        }
    }

    public static int decendingInt(int n){
        if (n==0){
            return 0;
        }else{
            System.out.println(n);
            return( decendingInt(n-1));

        }
    }

    public static int triangle(int n ){
        if (n==0){
            return 0;
        }else{
            int m = n;
            while (m>0){
                System.out.print("*");
                m--;
            }
            System.out.println();
            return (triangle(n-1));
        }

    }


    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please enter a non negative integer ");
        int num = scnr.nextInt();

        System.out.println("The sumover of your int is using the non recursive method is: "+ sumover(num));
        System.out.println("The sumover of your int is using the recursive method is: "+ recursiveSumover((double)(num)));
        System.out.println("The result of the decendingInt method is: ");
        decendingInt(num);
        System.out.println("Now lets print an inverse triangle! ");
        triangle(num);

    }
}
