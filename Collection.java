public interface Collection<E> extends Iterable<E> {
    public boolean add(E e);
    public boolean contains(Object o);
    public boolean isEmpty();
    public boolean remove(Object o);
    public int size();
}    
