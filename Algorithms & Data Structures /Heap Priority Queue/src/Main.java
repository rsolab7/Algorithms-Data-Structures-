import java.util.Scanner;
import java.lang.Math;
import java.util.Random;

public class Main {
    public static int comp;
    public static void main(String[] args) {
        Random randGen = new Random();
        MinHeap minHeap = new MinHeap(10);
        int add;
        for (int i = 1; i<=1000; i++){
            add = randGen.nextInt(1000)+1;
            comp = comp+1;
            if (i<=10){
                minHeap.insert(add);
                minHeap.minHeap();
            }else if (add > minHeap.getRoot()){
                comp = comp +1;
                minHeap.setRoot(add);
                minHeap.minHeap();
            }
        }
        minHeap.print();
        System.out.print("The total number of comparisons is: " + (comp+minHeap.getComp()));
    }
}

/*
In order to find the 10 best scores offline, first I'd read the entire array of values and perform a mergesort algorithm. After performing the
Mergesort in accending order, simply take the last values of the Array: Array[Size-1] - Array [ Size-10]. Those values will be the best scores.
The cost of performing a mergesort is O(n*log(n)) for which doing this in a array of 1000 elements the cost is around 3000 comparisons.
While doing the MinHeap the cost is around 1000 comparisons.
 */