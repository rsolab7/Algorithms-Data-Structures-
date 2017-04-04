
    import java.util.*;
    public class MainArray {


        public static void insertionSort (char[] charList) {
            //int len = charList.length;
            for (int i = 1; i < charList.length; i++) {
                char tmp = charList[i];
                int j = i;
                while (j > 0 && charList[j - 1] > tmp) {
                    charList[j] = charList[j - 1];
                    j--;
                }
                charList[j] = tmp;
            }
        }

        // Implementing Fisher–Yates shuffle
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



        public static void main(String[] args) {
            int sumComp =0;
            int sumSwamps =0;
            int c = 0;
            CircularLinkedList test = new CircularLinkedList();
            //New array size 100
            int[] myVals = new int[100];
            int [] shufA = new int[100];

            while (c<101){

                //Populate the arry with values from 1-100
                for (int i = 0; i < myVals.length; i++) {
                    myVals[i] = i;
                }
                //Shuffle values
                shuffleArray(myVals);
                //sort values & save the swamps and comp in into the array
                int[] a = sortInt(myVals);


                //System.out.println("Swamps:" + a[0] + " Comparisons: " + a[1]);
                sumComp = sumComp +a[1];
                sumSwamps = sumSwamps + a[0];

                c++;
            }
            //System.out.print(sumSwamps);
            System.out.println("The average number of comparisons is: " + sumComp/100 + " \nThe average number of swamps is: " + sumSwamps/100);


            shuffleArray(myVals);
            shufA = myVals;
            //System.out.print(shufA[0]);
            //Populate the LinkedList
            for (int i = 0; i < 100; i++){
                test.add(shufA[i]);
                //System.out.print(shufA[i]+" ");
            }
            test.sortLinkedList(test.returnHead());
            //test.print();
        }
    }


