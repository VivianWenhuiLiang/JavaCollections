public interface Queue<E> extends Collection<E> {
    public E peek();
    public E poll();
    public E remove();
    public E element();// return the head of content in this queue
    public boolean offer(E e);//add Vs remove;  offer Vs poll
                                            //push Vs pull
}    
