public class ArrayList<E> implements List<E> {
    private int size=0;
    private static final int DEFAULT_CAPACITY=4;
    private Object elements[];
    public ArrayList() {
        elements=new Object[DEFAULT_CAPACITY];
    }
    public boolean add (E e) {
        if(size==elements.length){
            elements = ensureCapacity(elements);
        }
        elements[size++]=e;
        return true;
    }

    public void add(int index, E ele) {
        if(index>size()||index<0){
            throw new IndexOutOfBoundsException(); 
        }
        if(size==elements.length){
            elements = ensureCapacity(elements);
         }
         int i;
         int count=size;
         for(i=count-1;i>=index;i--){
            elements[i+1]=elements[i];
         }  
         elements[index]=ele;
         size=size+1;
    }

    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if(size<=index||index<0){
             throw new IndexOutOfBoundsException(); 
        }
        int i;
        E res=(E)elements[index];
        for(i=index+1;i<size;i++){
            elements[i-1]=elements[i];             
        }
        elements[i-1]=null;
        size=size-1;
        return res;
    }

    public boolean remove(Object o) {
        for(int i=0;i<elements.length;i++){
            if(elements[i]==o){
                for(;i<size;i++){
                    elements[i-1]=elements[i];
                }
                elements[i-1]=null;
                size--;
                return true;
            }
        }
        return false;
    }
    
    @SuppressWarnings("unchecked")
    public E set(int index, E e) {
        if(size<=index||index<0){
             throw new IndexOutOfBoundsException(); 
        }
        E temper=(E)elements[index];
        elements[index]=e;
        return temper;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        if(size<=index||index<0){
             throw new IndexOutOfBoundsException(); 
        }
        return (E)elements[index];
    }


    public boolean isEmpty() {
        if(size==0){
            return true;
        }
        return false;
    }



    public int size() {
        return size;
    }



    public boolean contains(Object o) {
        for(int i=0;i<size;i++){
            if(elements[i]==o){
                return true;
            }
        }
        return false;
    }



    public static Object[] ensureCapacity(Object elements[]) {
        int newSize=elements.length*2;
         Object elementsTwo[]=new Object[newSize];
         for(int i=0;i<elements.length;i++){
            elementsTwo[i]=elements[i];
         }
         return elementsTwo;
    }
    public Iterator<E> iterator(){
        return new ArrayListIterator<E>(this);

    }
    @SuppressWarnings("unchecked")
    private static class ArrayListIterator<F> implements Iterator<F> {
        private ArrayList al;
        int index = 0;
        public ArrayListIterator(ArrayList<F> al) {
            this.al=al;
        }

        public boolean hasNext() {
            return index < al.size();
        }
        public F next() {
            F f = (F)al.elements[index];
            index++;
            return f;
        }
    }

public static void main(String [ ] args) {
    ArrayList<Integer> A=new ArrayList<>();
    check(A.size == 0, "Assertion: initial size should be 0.");
    check(A.elements.length == 4, "Assertion: initial length should be 4.");

    printArray(A.elements);

    A.add(1);
    printArray(A.elements);


    A.add(2);
    printArray(A.elements);

    A.add(3);
    printArray(A.elements);

    A.add(0,4);
    printArray(A.elements);

    check(A.size == 4, "Assertion: size should be 4 after adding 4 elements.");
    check(A.elements.length == 4, "Assertion: length should be 4 after adding 4 elements.");

    A.add(3,5);
    check(A.size == 5, "Assertion: size should be 5 after adding 5 elements.");
    check(A.elements.length == 8, "Assertion: length should be 8 after adding 5 elements.");
    printArray(A.elements);
    check(arrayEquals(A.elements, new Integer[]{4, 1, 2, 5, 3}, 5), "Assertion: elements must be 4 1 2 5 3");


    A.remove(0);
    check(A.size==4, "Assertion: size should be 4 after remove index[0] elements.");
    check(arrayEquals(A.elements, new Integer[]{1, 2, 5, 3}, 4), "Assertion: elements must be 1 2 5 3");


    A.set(3,4);
    check(arrayEquals(A.elements, new Integer[]{1, 2, 5, 4 }, 4), "Assertion: elements must be 1 2 5 4");
    printArray(A.elements);

    A.get(1);

    A.isEmpty();
    check(A.size!=0, "Assertion: Not empty.");

    A.size();
    check(A.size==4, "Assertion: size should be 4 .");

    A.contains(6);
   }

   public static void printArray(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
   }

   public static boolean arrayEquals(Object[] arr1, Object[] arr2, int size) {
        for (int i = 0; i < size; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
   }

    public static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }
}
