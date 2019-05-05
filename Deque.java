public interface Deque<E> extends Queue<E> {
    public void addFirst(E e);
    public void addLast(E e);
    public void getFirst(E e);
    public void getLast(E e);
    public E removeFirst();
    public E removeLast();
}    
