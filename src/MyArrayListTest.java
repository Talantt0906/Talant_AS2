public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(5);
        list.add(7);
        list.add(9);
        System.out.println("List after add: " + printList(list));

        list.add(1, 6);
        System.out.println("List after add at index 1: " + printList(list));

        list.addFirst(3);
        list.addLast(10);
        System.out.println("List after addFirst and addLast: " + printList(list));

        list.set(2, 100);
        System.out.println("List after set index 2 to 100: " + printList(list));

        System.out.println("Element at index 3: " + list.get(3));
        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());

        list.remove(2);
        System.out.println("List after remove index 2: " + printList(list));

        list.removeFirst();
        System.out.println("List after removeFirst: " + printList(list));

        list.removeLast();
        System.out.println("List after removeLast: " + printList(list));

        list.add(7);
        list.add(7);
        System.out.println("List after adding 7 twice: " + printList(list));
        System.out.println("Index of 7: " + list.indexOf(7));
        System.out.println("Last index of 7: " + list.lastIndexOf(7));
        System.out.println("Exists 100? " + list.exists(100));
        System.out.println("Exists 500? " + list.exists(500));

        Object[] arr = list.toArray();
        System.out.print("Array from toArray(): ");
        for (Object obj : arr) {
            System.out.print(obj + " ");
        }
        System.out.println();

        list.add(2);
        list.add(8);
        System.out.println("List before sort: " + printList(list));
        list.sort();
        System.out.println("List after sort: " + printList(list));

        list.clear();
        System.out.println("List after clear: " + printList(list));
        System.out.println("Size after clear: " + list.size());
    }

    public static String printList(MyArrayList<Integer> list) {
        String result = "";
        for (Integer item : list) {
            result += item + " ";
        }
        return result.trim();
    }
}

