public interface Deque<E> extends Queue<E> {
    public void addFirst(E e);
    public void addLast(E e);
    public E getFirst();
    public E getLast();
    public E removeFirst();
    public E removeLast();
}    
