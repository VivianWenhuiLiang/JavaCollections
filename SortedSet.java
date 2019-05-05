public Interface SortedSet<E>{
    public E first();
    public E last();
    public SortedSet<E> headSet(E toElement);
    public SortedSet<E> subSet(E fromElement , E toElement);
    public SortedSet<E> tailSet(E fromElement);
}
