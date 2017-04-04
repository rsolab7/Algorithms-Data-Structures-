import java.util.Random;
import java.util.Scanner;


public class MergeSort {

    static int totalComp =0;
    static int totalSwamp =0;
	public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
		Random generator = new Random(30);
		int[] testData10=new int[10];
		//generate random data
		for (int i=0; i<testData10.length;i++){
			int randomNumber=(int) (generator.nextDouble()*100) +1;
			testData10[i]=randomNumber;
		}

		int[] testData100=new int[100];
		//generate random data
		for (int i=0; i<testData100.length;i++){
			int randomNumber=(int) (generator.nextDouble()*100) +1;
			testData100[i]=randomNumber;
		}
		
		int[] testData1000=new int[1000];
		//generate random data
		for (int i=0; i<testData1000.length;i++){
			int randomNumber=(int) (generator.nextDouble()*100) +1;
			testData1000[i]=randomNumber;
		}

        mergeSort(testData10);
        mergeSort(testData100);
        mergeSort(testData1000);
        //for (int i=0; i<testData10.length;i++){
          //  System.out.print(testData10[i] + " ");
        //}
        /*
        System.out.println();
        for (int i=0; i<testData100.length;i++){
            System.out.print(testData100[i] + " ");
        }
        System.out.println();
        for (int i=0; i<testData1000.length;i++){
            System.out.print(testData1000[i] + " ");
        } */
        //System.out.println("The total number of comp is " + totalComp + " the total number of swamps is " + totalSwamp);

        System.out.println("-------------------PART 2-----------------");

        System.out.print("Please enter a String: ");
        permutation(scnr.nextLine());
	}
	
	public static void mergeSort(int[] data){
		//call the recursive mergeSort method
		mergeSort(data, 0, data.length-1);
	}

	private static void mergeSort(int[] data, int startIndex, int endIndex) {

		// recursion condition
		if (startIndex<endIndex){
			
			//find index of middle element
			int midIndex= (startIndex+endIndex)/2;
			
			//recursive calls to sort each side
			mergeSort(data, startIndex, midIndex);
			mergeSort(data, midIndex+1, endIndex);
			//FIXME STOP if largest item in first half <= smallest item in second half

			//merge the elements from each side of the array		
			merge(data, startIndex, midIndex, endIndex);
			
		}
		
	}

	public static void merge (int [] data, int lo, int mid, int hi){
		int [] temArray = new int[data.length];
		int i = lo;
		int j = mid+1;
        int c = lo;
        int s =0;
        if (data[mid]<=data[j]){
            s = 1;
        }
        if (s==0) {
            while (i <= mid && j <= hi) {
                totalComp++;
                if (data[i] <= data[j]) {
                    temArray[c] = data[i];
                    totalSwamp++;
                    i++;
                    c++;
                } else if (data[i] > data[j]) {
                    totalSwamp++;
                    temArray[c] = data[j];
                    j++;
                    c++;
                }
            }
            while (i <= mid) {
                totalSwamp++;
                temArray[c] = data[i];
                i++;
                c++;
            }
            while (j <= hi) {
                totalSwamp++;
                temArray[c] = data[j];
                j++;
                c++;
            }
        }
        for (int k = lo; k<= hi; k++){
            totalComp++;
            data[k] = temArray[k];
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

    public static void permutation(String str) {
        permutation("", str);
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }
}

