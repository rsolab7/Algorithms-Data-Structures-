import java.security.PublicKey;
import java.util.*;

public class Main {
    static int count = 0;
    static int count2 = 0;


    static void shuffleArray(int[] ar)
    {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    public static int[] sortInt (int[] intList){
        int comp = 0;
        int swamps = 0;
        for (int i =1; i<intList.length; i++){
            int tmp = intList[i];
            int j = i;
            while (j>0 && intList[j-1] > tmp){
                comp ++;
                intList[j] = intList[j-1];
                j--;
            }
            comp++;
            swamps++;
            intList[j] = tmp;
        }
        int[] myList = {swamps,comp};
        return myList;
    }

    public static int sequentialSearch(int [] intArray, int num){
        for(int i = 0; i<intArray.length;i++){
            count++;
            if(num == intArray[i]){
                return i;
            }
        }
            return -1;
    }

    public static int binarySearch (int [] intArray, int num){
        int hi = intArray.length;
        int lo = 0;
        while (hi>lo){
            int mid = lo + (hi - lo)/2;

            if (num<intArray[mid]) {
                hi = mid - 1;
                count2++;
            } else if (num>intArray[mid]){
                lo = mid +1;
                count2++;
            }
            else return mid;
        }
        return -1;
    }

    public static int maxRecursive(int [] intArray, int lo, int hi ){
        if (lo==hi)
            return intArray[lo];
        else {
            int mid = (hi + lo) / 2;
            int max1 = maxRecursive(intArray, lo, mid);
            int max2 = maxRecursive(intArray, mid+1, hi);
            if (max1>max2){
                return max1;
            }else{
                return max2;
            }
        }
    }

    public static void recursiveInsertionSort (int [] intArray, int index){
        if (index == 0){
            return;
        }else{
            int temp;
            int size = intArray.length;
            recursiveInsertionSort(intArray,index-1);
            int j = index;
            temp = intArray[index];
            while (j > 0 && temp < intArray[j-1] ) {
                intArray[j] = intArray[j - 1];
                j--;
            }
            intArray[j] = temp;
            return;
        }
    }





    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Random generator = new Random(25);
        int[] testData100 = new int[100];
        //generate random data
        for ( int i=0; i < testData100.length; i++){
            int randomNumber = (int) (generator.nextDouble() * 100) + 1;
            testData100[i] = randomNumber;
            //System.out.print(testData100[i]+" ");
        }
        //System.out.println("");
        //sortInt(testData100);

        //Sort array using recursive insertion sort
        recursiveInsertionSort(testData100, testData100.length-1);

       for ( int i=0; i < testData100.length; i++){
            System.out.print(testData100[i]+" ");
       }
        System.out.println("");


        System.out.println("Which number you wish to find in the Array using sequentialSearch & binary search ");
        int a = scnr.nextInt();

        //PRINT THE INDEX OF THE NUMBER LOOKING FOR
        System.out.println("Sequiential Search: The index is: "+sequentialSearch(testData100,a));
        System.out.println("Binary Search: The index is: "+ binarySearch(testData100, a));
        // PRINT THE NUMBER OF COMPARISONS PERFORMED
        System.out.println("the Number of comparisons in the sequentialSearch is "+count);
        System.out.println("the Number of comparisons in the binary search is "+count2);
        System.out.println("The Maximun number in the Array is: " + maxRecursive(testData100,0,testData100.length-1));



    }
}
