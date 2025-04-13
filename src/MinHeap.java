public class MinHeap {public class minHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap;

    public minHeap() {
        heap = new MyArrayList<>();
    }

    public void insert(T item) {
        heap.add(item);
        siftUp(heap.size() - 1);
    }

    public T extractMin() {
        if (heap.size() == 0) {
            return null;
        }
        T min = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.removeLast();
        siftDown(0);
        return min;
    }

    public T peekMin() {
        if (heap.size() > 0) {
            return heap.get(0);
        }
        return null;
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    private void siftUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parentIndex)) >= 0) {
                break;
            }
            T temp = heap.get(index);
            heap.set(index, heap.get(parentIndex));
            heap.set(parentIndex, temp);
            index = parentIndex;
        }
    }

    private void siftDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallest = index;

        if (leftChildIndex < heap.size() && heap.get(leftChildIndex).compareTo(heap.get(smallest)) < 0) {
            smallest = leftChildIndex;
        }
        if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(smallest)) < 0) {
            smallest = rightChildIndex;
        }
        if (smallest != index) {
            T temp = heap.get(index);
            heap.set(index, heap.get(smallest));
            heap.set(smallest, temp);
            siftDown(smallest);
        }
    }

    public Object[] toArray() {
        return heap.toArray();
    }

    public void printHeap() {
        for (int i = 0; i < heap.size(); i++) {
            System.out.print(heap.get(i) + " ");
        }
        System.out.println();
    }
}

}
