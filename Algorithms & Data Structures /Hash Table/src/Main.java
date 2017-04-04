import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        int p = 63;
        System.out.print("Enter 1 for Division method and 2 for the multiplication method:");
        int dm = scanner.nextInt();
        while (flag){
            int m;
            Random randGen = new Random();
            //Manual size
            //System.out.print("Enter the value of m, the size of the table ");
            //m = scanner.nextInt();

            //Automatic table size increase
            p++;
            m = p;
            double sumColPer=0;
            double sumcol = 0;
            if (p == 129) break;
            for (int i = 0; i<100; i++){
                double colisionsPercentage = 0;
                HashMap Hmap = new HashMap(m);
                int [] elementsToAdd = new int[m];
                for (int j = 0; j<m; j++){
                    elementsToAdd[j] = randGen.nextInt(1000)+1;
                    //Mutually exclusive statememnts, can't be run at the same time
                    if (dm == 1){
                        if (i==0 && j==0)
                        System.out.println("----------DIVISION METHOD---------\n          hash = (key % m)");
                        Hmap.putDivision(elementsToAdd[j]);
                    }else{
                        if (i==0 && j==0)
                        System.out.println("----------MULTIPLICATION METHOD---\n          A =((Math.sqrt(5)-1)/2)");
                        Hmap.putMultiplication(elementsToAdd[j]);
                    }
                }
                int c = Hmap.getCountColisions();
                //System.out.println("The number of colisions on a table size "+ m+ " was "+Hmap.getCountColisions());
                colisionsPercentage = (double) c / (double) m;
                //System.out.println("The percentage of colisions on a table size "+ m+ " was "+colisionsPercentage);
                sumColPer = sumColPer + colisionsPercentage;
                sumcol = sumcol + c;
            }
            System.out.println("-----------TABLE SIZE = "+ m+ "-------------");
            System.out.println("The mean of the 100th collision percentages for a table size "+ m+ " is:" + sumColPer/100);
            System.out.println("The average of the sum of all collision of the 100th runs for a table size "+m+ " is:" + sumcol/100);
            System.out.println("---------------------------------------");

            //IF manual Size
           /*
            System.out.print("Do you wish to continue: Y/N: ");
            String f = scanner.next();
            if (f.toUpperCase().equals("N")){
            flag = false;
                System.out.print("--Program Ended--");
            }
            */
        }
    }
}

/*
    Division Method:
    As table size and number of elements increase the number of colisions increase as well

    Multiplication Method
 */