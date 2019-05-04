public Interface Queue<E>{
    public boolean add(E e);
    
    public E   peek();
    
    public E   poll();
    
    public E   remove();
    
    public E   element();// return the head of content in this queue
}    
