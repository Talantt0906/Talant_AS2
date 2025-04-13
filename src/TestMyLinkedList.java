public class TestMyLinkedList {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        System.out.println("Size: " + list.size());
        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());

        list.addFirst(5);
        list.addLast(50);

        System.out.println("After adding first and last: ");
        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());

        list.remove(2);
        System.out.println("After removing element at index 2: ");
        System.out.println("Size: " + list.size());
        System.out.println("Element at index 2: " + list.get(2));

        list.removeFirst();
        list.removeLast();
        System.out.println("After removing first and last: ");
        System.out.println("Size: " + list.size());

        list.set(1, 100);
        System.out.println("After setting index 1 to 100: ");
        System.out.println("Element at index 1: " + list.get(1));

        System.out.println("Index of 30: " + list.indexOf(30));
        System.out.println("Last index of 30: " + list.lastIndexOf(30));

        System.out.println("Does 100 exist in the list? " + list.exists(100));
        System.out.println("Does 20 exist in the list? " + list.exists(20));

        list.sort();
        System.out.println("After sorting: ");
        for (Integer value : list) {
            System.out.println(value);
        }

        list.clear();
        System.out.println("After clearing: ");
        System.out.println("Size: " + list.size());
    }
}

