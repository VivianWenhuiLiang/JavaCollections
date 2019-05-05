// we only care about iterator method will skip forEach and spliterator method
public interface Iterable<T> {
    public Iterator<T> iterator();
}
