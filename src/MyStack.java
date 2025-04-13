import java.util.Iterator;

public class MyStack<T> implements MyList<T> {
    private MyLinkedList<T> list;

    public MyStack() {
        list = new MyLinkedList<>();
    }

    @Override
    public void add(T item) {
        list.addFirst(item);
    }

    @Override
    public T get(int index) {
        return list.get(index);
    }

    @Override
    public T getFirst() {
        return list.getFirst();
    }

    @Override
    public T getLast() {
        return list.getLast();
    }

    @Override
    public void remove(int index) {
        list.remove(index);
    }

    @Override
    public void removeFirst() {
        list.removeFirst();
    }

    @Override
    public void removeLast() {
        list.removeLast();
    }

    @Override
    public void add(int index, T item) {
        list.add(index, item);
    }

    @Override
    public void set(int index, T item) {
        list.set(index, item);
    }

    @Override
    public void addFirst(T item) {
        list.addFirst(item);
    }

    @Override
    public void addLast(T item) {
        list.addLast(item);
    }

    @Override
    public int indexOf(Object object) {
        return list.indexOf(object);
    }

    @Override
    public int lastIndexOf(Object object) {
        return list.lastIndexOf(object);
    }

    @Override
    public boolean exists(Object object) {
        return list.exists(object);
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public void sort() {

    }
}

