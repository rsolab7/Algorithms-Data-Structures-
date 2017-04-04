public class MaxHeap {
    private int[] Heap;
    private int size;
    private int maxsize;

    private static final int FRONT = 1;

    public MaxHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MAX_VALUE;
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
    }

    private void maxHeapify(int pos) {
        if (!isLeaf(pos)) {
            if (Heap[pos] < Heap[leftChild(pos)] || Heap[pos] < Heap[rightChild(pos)]) {
                if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    maxHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    maxHeapify(rightChild(pos));
                }
            }
        }
    }

    private void maxHeapifyLoop(int[] a, int i, int n){
        while (i<= n){
            int left = leftChild(i);
            int right = rightChild(i);
            int largest;
            if ((left <= n) && (a[left]>a[i])){
                 largest = left;
            }else{
                 largest = i;
            }if ((right <= n) && (a[right]>a[i])) {
                 largest = right;
            } if (largest != i){
                swap(i, largest);
                i = largest;
            }
            else
                break;
        }
    }


    public void insert(int element) {
        if ((size +1) >= maxsize) {
            System.out.print("MaxHeap is full - Terminating Program");
            System.exit(1);
        }
        Heap[++size] = element;
        int current = size;
        while (Heap[current] > Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2 * i]
                    + " RIGHT CHILD :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }

    public void maxHeap() {
        for (int pos = (size / 2); pos >= 1; pos--) {
            maxHeapify(pos);
        }
    }


    public int remove() {
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        maxHeapify(FRONT);
        return popped;
    }

    public void heapSort (){
        int n = Heap.length;
        maxHeap();
        for (int i = n; i<=2; i--){
            swap(1,i);
            n--;
            maxHeapify(1);
        }
    }
    public int getSize(){
        return size;
    }

    public void printlist (){
        for (int i = 1; i <= size; i++){
            System.out.print(Heap[i]+ " ");
        }
        System.out.println();
    }

}