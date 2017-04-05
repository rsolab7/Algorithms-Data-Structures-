/**
 * Created by Roberto on 11/18/16.
 */
public class MinHeap {
    private int[] Heap;
    private int size;
    private int maxsize;
    //Calculate the number of comparisons done by the Heap
    //This estimates the complexity of the implementation 
    public static int comp;


    private static final int FRONT = 1;

    public MinHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MIN_VALUE;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos);
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    private void swap(int fpos, int spos) {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
        comp = comp+3;
    }

    public void minHeapify(int pos) {
        comp = comp+1;
        if (!isLeaf(pos)) {
            comp = comp+2;
            if (Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)]) {
                    comp = comp+1;
                if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    public void insert(int element) {
        Heap[++size] = element;
        int current = size;

        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void print() {
        for (int i = 1; i <=size / 2; i++) {
            if (i == size/2){
                System.out.println(" PARENT : " + Heap[i]+ " LEFT CHILD : " + Heap[2 * i]);
            }else{
                System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2 * i]
                        + " RIGHT CHILD :" + Heap[2 * i + 1]);
                System.out.println();
            }
        }
    }

    public void minHeap() {
        for (int pos = (size / 2); pos >= 1; pos--) {
            minHeapify(pos);
        }
    }

    public int remove() {
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);
        return popped;
    }

    public int getRoot() {
        return Heap[1];
    }

    public void setRoot(int n) {
        Heap[1] = n;
        return;
    }
    public int getComp(){
        return comp;
    }
}
