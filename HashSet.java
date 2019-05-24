public class HashSet<E> implements Set<E> {
    private HashMap<E, Object> hm = new HashMap<>();
    public boolean add(E e) {
        return hm.put(e, e)==null;
    }
    public boolean contains(Object o) {
        return hm.containsKey(o);
    }
    public boolean isEmpty() {
        return hm.isEmpty();
    }
    public boolean remove(Object o) {
        return hm.remove(o) != null;

    }
    public int size() {
        return hm.size();
    }
    public Iterator<E> iterator() {//will TODO 
        return hm.keySet().iterator();
    }


    public static void main (String []args) {
        HashSet<Integer> hs = new HashSet<>();
        check(hs.add(1),"1 in the set");
        check(hs.contains(1),"contained 1");
        check(!hs.contains(2),"not contained 2");

        printHashSet(hs);

        check(hs.add(2),"1 2 in the set");
        check(hs.contains(2),"contained 2");
        printHashSet(hs);

        check(!hs.add(1),"1 already in the set");
        printHashSet(hs);

        check(hs.remove(1), "1 removed");
        check(hs.size() == 1, "size should be 1, only contains 2");
        check(!hs.contains(1), "1 should not be contained");
        check(hs.contains(2), "2 should be contained");
        printHashSet(hs);

        check(hs.add(1),"1 2 in the set");
        check(hs.add(3),"1 2 3 in the set");       
        check(hs.add(4),"1 2 3 4 in the set");
        check(hs.size()==4,"1 2 3 4 in the set");
        check(hs.contains(4),"contained 4");
        check(!hs.isEmpty(),"size is 4");
        printHashSet(hs);
        check(hs.remove(3),"1 2 4 in the set");
        check(hs.size()==3,"1 2 4 in the set");
        printHashSet(hs);
    }

    public static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    public static void printHashSet( HashSet h) {
        Iterator iterator = h.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}