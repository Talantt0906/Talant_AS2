import java.util.Iterator;

public class MyArrayList<T> implements MyList<T>, Iterable<T> {
    private Object[] elements;
    private int size;

    public MyArrayList() {
        elements = new Object[10];
        size = 0;
    }

    @Override
    public void add(T item) {
        if (size < elements.length) {
            elements[size] = item;
            size++;
        }
    }

    @Override
    public void set(int index, T item) {
        if (index >= 0 && index < size) {
            elements[index] = item;
        }
    }

    @Override
    public void add(int index, T item) {
        if (index >= 0 && index <= size) {
            for (int i = size; i > index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index] = item;
            size++;
        }
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        if (index >= 0 && index < size) {
            return (T) elements[index];
        }
        return null;
    }

    @Override
    public T getFirst() {
        if (size > 0) {
            return (T) elements[0];
        }
        return null;
    }

    @Override
    public T getLast() {
        if (size > 0) {
            return (T) elements[size - 1];
        }
        return null;
    }

    @Override
    public void remove(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                elements[i] = elements[i + 1];
            }
            elements[size - 1] = null;
            size--;
        }
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        if (size > 0) {
            elements[size - 1] = null;
            size--;
        }
    }

    @Override
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (((Comparable<T>) elements[i]).compareTo((T) elements[j]) > 0) {
                    Object temp = elements[i];
                    elements[i] = elements[j];
                    elements[j] = temp;
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        System.arraycopy(elements, 0, result, 0, size);
        return result;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return (T) elements[index++];
            }
        };
    }
}



