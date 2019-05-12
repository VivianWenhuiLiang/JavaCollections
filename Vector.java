public class Vector<E> implements List<E> {
    private ArrayList<E> arrayList = new ArrayList<>();

    public synchronized boolean add(E e) {
        return arrayList.add(e);
    }

    public synchronized boolean contains(Object o) {
        return arrayList.contains(o);
    }
    public  synchronized boolean isEmpty() {
        return arrayList isEmpty();
    }
    public synchronized boolean remove(Object o) {
        return arrayList.remove(o);
    }
    public synchronized int size() {
        return arrayList.size();
    }

    public synchronized void add(int index, E element) {
        return arrayList.add(index, element);
    }
    public synchronized E get(int index) {
        return arrayList.get(index);
    }
    public synchronized E remove(int index) {
        return arrayList.remove(index);
    }
    public synchronized E set(int index, E element) {
        return set(index, element);
    }

    public synchronized Iterator<T> iterator() {
        return null;//TODO,not yet implemented
    }


    public static void main(String [] args) {
        vector<int> v = new vector<>();
        v.add(1);
        printVector(v);
        v.add(2);
        printVector(v);
        v.add(3);
        printVector(v);
        check(size()==3," 1,2,3,  size 3");

        v.contains(3);
        v.isEmpty();
        check(size!=0,"size 3");

        v.remove(3);
        check(size()==2," 1,2,  size 2");
        printVector(v);

        v.size();
        check(size()=2,"size 2");

        v.add(2, 4);
        chec
        v.add(3, 5);
        v.get(3);
        v.remove(0);
        v.set(2.3);
        v.set(3.4);
    }
    public static void printVector(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
    }
    public static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }
}
