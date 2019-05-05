public interface Collection<E>{
    public boolean  add(E e);
    
    public boolean contains(Object o);
    
    public boolean equals(Object o);
    
    public boolean isEmpty();
    
    public Iterator<E> iterator();
    
    public boolean remove(Object o);
    
    public int size();
    
    public Object[] toArray();
}    
