public class Main {

    public static void main(String[] args) {
        System.out.println("Max Heap Implementation");
        MaxHeap maxHeap = new MaxHeap(15);
        MinHeap minHeap = new MinHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);
        maxHeap.maxHeap();
        maxHeap.heapSort();
        maxHeap.printlist();


        System.out.println("Min Heap Implementation");

        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        minHeap.minHeap();
        minHeap.heapSort();
        minHeap.printlist();
    }
}
