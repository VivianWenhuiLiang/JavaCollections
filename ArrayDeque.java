import java.lang.NullPointerException;
import java.util.NoSuchElementException;
public class ArrayDeque<E> implements Deque<E> {
    private int size = 0;
    private int head = -1;
    private int tail = -1;
    private static final int CAPACITY = 5;
    private Object elements[];
    public ArrayDeque() {
        elements = new Object[CAPACITY];
    }


    public void addFirst(E e) {
        if(e == null) {
            throw new NullPointerException();
        }
        if(size == elements.length) {
            elements = ArrayList.ensureCapacity(elements);
        }
        if(head == -1 && tail == -1) {
            elements[0] = e;
            head = 0;
            tail = 0;
        } else {
            int i = (head - 1) % elements.length;
            elements[i] = e;
            head = i;
        }
        size++;

    }
    public void addLast(E e) {
        if(e == null) {
            throw new NullPointerException();
        }
        if(size == elements.length) {
            elements = ArrayList.ensureCapacity(elements);
        }
        if(head == -1 && tail == -1) {
            elements[0] = e;
            head = 0;
            tail = 0;
        } else {
            int i = (tail + 1) % elements.length;
            elements[i] = e;
            tail = i;
        }
        size++;



    }
    @SuppressWarnings("unchecked")
    public E getFirst() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        return (E)elements[head];
    }

    @SuppressWarnings("unchecked")
    public E getLast() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        return (E)elements[tail];
    }

    @SuppressWarnings("unchecked")
    public E removeFirst() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        E holder = (E)elements[head];
        head = (head + 1) % elements.length;
        size--;
        return holder;
    }

    @SuppressWarnings("unchecked")
    public E removeLast() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        E holder = (E)elements[tail];
        tail = (tail - 1) % elements.length;
        size--;
        return holder;
    }

    public boolean add(E e) {
        if(e == null) {
            throw new NullPointerException();
        }
        addLast(e);
        return true;
    }
    public boolean contains(Object o) {
        int i = head;
        for( ; i < size(); i++) {
            ;
            int j = i % elements.length;
            if(o.equals(elements[j])) {
                return true;
            }
        }
        return false;
    }
    public boolean isEmpty() {
        return size() == 0;
    }
    public boolean remove(Object o) {
        if(!contains(o)) {
            return false;
        }
        if(o.equals(elements[head])) {
            removeFirst();
        }
        if(o.equals(elements[tail])) {
            removeLast();
        }
        int i = head;
        for(; i < size(); i++) {
            i = i % elements.length;
            if(o.equals(elements[i])) {
                moveBack(i);
                return true;
            }
        }
        return false;
    }

    public void moveBack(int i) {
        for( ; i != tail; i = (i + 1) % elements.length) {
            elements[i] = elements[i + 1];
        }
        tail = tail - 1;
        size--;
    }
    public int size() {
        return size;
    }

    public E peek() {
        if(isEmpty()) {
            return null;
        }
        return getFirst();
    }
    public E poll() {
        if(isEmpty()) {
            return null;
        }
        return removeFirst();
    }
    public E remove() {
        return removeFirst();
    }
    public E element() {
        return getFirst();
    }
    public boolean offer(E e) {
            addLast(e);
            return true;
   

    }
    @SuppressWarnings("unchecked")
    private static class ArrayDequeIterator<E> implements Iterator<E> {
        private ArrayDeque ad;
        private int count = 0;
        public ArrayDequeIterator(ArrayDeque<E> ad) {
            this.ad = ad;
        }

        public boolean hasNext() {
            return count < ad.size();
        }
        public E next() {
            E temp = (E)ad.elements[(ad.head + count) % ad.elements.length];
            count++;
            return temp;
        }
    }

    public Iterator<E> iterator(){
        return new ArrayDequeIterator<E>(this);

    }
    public static void main(String [ ] args) {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.addFirst(1);
        check(ad.size()==1,"1 in the ArrayDeque");
        printArray(ad.elements);
        ad.addLast(2);
        ad.addLast(3);
        ad.addLast(4);
        ad.addLast(5);
        printArray(ad.elements);

        ad.addLast(6);
        check(ad.size()==6,"123456 in the ArrayDeque");
        printArray(ad.elements);

        check(ad.getFirst()==1,"first element in ArrayDeque is 1");
        check(ad.getLast()==6,"last element in the array is 6");

        ad.removeFirst();

        check(ad.size()==5,"2 3 4 5 6 ");
        System.out.print(ad.head+":"+ad.tail+"; ");
        printArray(ad.elements);

        ad.removeLast();
        check(ad.size()==4,"2 3 4 5  ");
        System.out.print(ad.head+":"+ad.tail+"; ");

        printArray(ad.elements);
        check(!ad.contains(6),"2 3 4 5 in the array");
        check(!ad.isEmpty(),"size=4");

        ad.remove(4);
        check(ad.size()==3,"2 3 5  ");
        System.out.print(ad.head+":"+ad.tail+"; ");
        printArray(ad.elements);


        check(ad.size()==3,"2 3 5 in the array");
        check(ad.peek()==2,"first element is 2");
        check(ad.poll()==2,"3 5 in the array");
        System.out.print(ad.head+":"+ad.tail+"; ");
        printArray(ad.elements);

        ad.offer(7);
        ad.offer(8);
        check(ad.size()==4,"3 5 7 8");
        printArray(ad.elements);

        check(ad.element()==3,"3 is the first element");
    }


    public static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }
    public static void printArray(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
   }







}