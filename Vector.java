public class Vector<E> implements List<E> {
    private ArrayList<E> arrayList = new ArrayList<>();

    public synchronized boolean add(E e) {
        return arrayList.add(e);
    }

    public synchronized boolean contains(Object o) {
        return arrayList.contains(o);
    }
    public  synchronized boolean isEmpty() {
        return arrayList.isEmpty();
    }
    public synchronized boolean remove(Object o) {
        return arrayList.remove(o);
    }
    public synchronized int size() {
        return arrayList.size();
    }

    public synchronized void add(int index, E element) {
        arrayList.add(index, element);
    }
    public synchronized E get(int index) {
        return arrayList.get(index);
    }
    public synchronized E remove(int index) {
        return arrayList.remove(index);
    }
    public synchronized E set(int index, E element) {
        return arrayList.set(index, element);
    }

    public synchronized Iterator<E> iterator() {
        return null;//TODO,not yet implemented
    }


    public static void main(String [] args) {
        Vector<Integer> v = new Vector<>();
        v.add(1);
        printVector(v);
        v.add(2);
        printVector(v);
        v.add(3);
        printVector(v);
        check(v.size()==3," 1,2,3,  size 3");

        v.contains(3);
        v.isEmpty();
        check(v.size()!=0,"size 3");

        v.remove(2);
        check(v.size()==2," 1,2,  size 2");
        printVector(v);

        v.size();
        check(v.size()==2,"size 2");

        v.add(0, 4);//insert in [0]
        check(v.size()==3,"4,1,2 in the vector");
        printVector(v);
        v.add(1, 5);
        check(v.size()==4,"4,5,1,2in the vector");
        printVector(v);
        v.get(3);
        v.remove(0);
        check(v.size()==3,"5,1,2 in the vector");
        printVector(v);
        v.set(0,3);
        check(v.size()==3,"3 ,1,2 in the vector");
        printVector(v);
    }
    public static void printVector(Vector v) {
        for (int i = 0; i < v.size(); i++) {
            System.out.print(v.get(i));
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
