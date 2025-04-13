public class MyLinkedList<T> implements MyList<T>, Iterable<T> {

    private class MyNode {
        T data;
        MyNode next;
        MyNode prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(T item) {
        MyNode newNode = new MyNode(item);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void addFirst(T item) {
        MyNode newNode = new MyNode(item);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            return;
        }

        MyNode newNode = new MyNode(item);

        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            add(item);
        } else {
            MyNode current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            newNode.next = current;
            newNode.prev = current.prev;
            if (current.prev != null) {
                current.prev.next = newNode;
            }
            current.prev = newNode;
            size++;
        }
    }

    @Override
    public T get(int index) {
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current != null ? current.data : null;
    }

    @Override
    public T getFirst() {
        return head != null ? head.data : null;
    }

    @Override
    public T getLast() {
        return tail != null ? tail.data : null;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        if (current == head) {
            head = current.next;
            if (head != null) {
                head.prev = null;
            }
        } else if (current == tail) {
            tail = current.prev;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(Object object) {
        MyNode current = head;
        for (int i = 0; i < size; i++) {
            if (current.data.equals(object)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        MyNode current = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (current.data.equals(object)) {
                return i;
            }
            current = current.prev;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        MyNode current = head;
        for (int i = 0; i < size; i++) {
            array[i] = current.data;
            current = current.next;
        }
        return array;
    }

    @Override
    public void set(int index, T item) {
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        if (current != null) {
            current.data = item;
        }
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size - 1);
    }

    @Override
    public void sort() {
        if (size <= 1) return;

        boolean swapped;
        do {
            swapped = false;
            MyNode current = head;
            while (current != null && current.next != null) {
                if (((Comparable<T>) current.data).compareTo(current.next.data) > 0) {
                    T temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private MyNode current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}





