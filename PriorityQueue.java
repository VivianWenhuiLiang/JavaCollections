import java.util.NoSuchElementException;
import java.util.Comparator;
import java.lang.NullPointerException;
public class PriorityQueue<E> implements Queue<E> {
    private int size=0;
    private int rear=0;
    private static final int DEFAULT_CAPACITY=5;
    private Object queue[];

    public PriorityQueue() {
        queue=new Object[DEFAULT_CAPACITY];
    }
    @SuppressWarnings("unchecked")
    public E peek() {
        if(!isEmpty()) {
            return (E)queue[0];
        }
        return null;
    }
    @SuppressWarnings("unchecked")
    public E poll() {
        if(isEmpty()) {
            return null;
        }
        E holder=(E)queue[0];
        moveFor(0);
        return holder;
    }

    public E remove(){
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        return poll();
    }

    public E element() {// return the head of this queue,but doesn't remove
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        return peek();
    } 
    @SuppressWarnings("unchecked")
    public boolean offer(E e) {//inserts
        if(e==null) {
            throw new NullPointerException();
        }
        if(size()==0){
            queue[0]=e;
            size++;
            return true;
        }
        if(size==queue.length) {
         enSureSize();
        }
        int i=findIndex(e);
        System.out.println("found index="+i);
        moveBack(i);
        queue[i]=e;
        return true;
    }

    public boolean add(E e) {
        System.out.println("adding " + e);
        return offer(e);
    }

    public boolean contains(Object o) {
        for(int i=0;i<size();i++){
            if(o.equals(queue[i])) {
                return true;
            }
        }
        return false;

    }
    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }

    public boolean remove(Object o) {
        for(int i=0;i<size();i++){
            if(o.equals(queue[i])) {
                moveFor(i);
                remove(o);
                return true;
            }
        }
        return false;
    }
    public int size() {
        return size;
    }
    public Iterator<E> iterator() {//TO-DO
        return null;
    }
    @SuppressWarnings("unchecked")
    public int findIndex(Object e) {
        if(isEmpty()) {
            return -1;
        }
        int i=0;
        int j=size()-1;
        int mid=(j+i)/2;
        for( ;i<=j; ) {
            if(queue[mid].equals(e)) {
                return mid;
            }

            if(((Comparable)queue[mid]).compareTo(e)<0) {
                i=mid+1;
            }
            else {
                j=mid-1;
            }
            mid=(j+i)/2;
        }
        return i;
    }

    public void moveBack(int i){
        for(int j=size()-1;j>=i;j--) {
            queue[j+1]=queue[j];
        }
        size++;
    }

    public void moveFor(int i) {
        for(;i<size()-1;i++ ) {
            queue[i]=queue[i+1];
        }
        size--;
    }

    public void enSureSize() {
        int newSize=queue.length*2;
        Object newQueue[]=new Object[newSize];
        for(int i=0;i<queue.length;i++){
            newQueue[i]=queue[i];
         }
        queue=newQueue;
    }


    public static void main(String[] args) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.add(1);
        printQueue(pq);
        pq.add(4);
        printQueue(pq);
        pq.add(8);
        printQueue(pq);
        pq.add(6);
        printQueue(pq);
        pq.offer(5);
        printQueue(pq);
        pq.offer(3);
        printQueue(pq);
        check(pq.size()==6,"queue include 1,3,4,5,6,8");

        pq.remove(6);
        printQueue(pq);
        check(pq.size()==5,"queue include 1,3,4,5,8");
        check(!pq.isEmpty(),"queue include 1,3,4,5,8");
        pq.size();
        check(pq.size()==5,"queue include 1,3,4,5,8");
        pq.contains(1);
        pq.peek();
        pq.poll();
        printQueue(pq);
        check(pq.size()==4,"queue include 3,4,5,8");
        pq.remove();
        printQueue(pq);
        check(pq.size()==3,"queue include 4,5,8");
        pq.element();  
    }
    public static void printQueue(PriorityQueue arr) {
           for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.queue[i]);
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