import java.util.NoSuchElementException;
@SuppressWarnings("unchecked")
public class LinkedList<E> implements List<E>, Deque<E> {
    private static class Node<F> {
        private Node next;
        private F data; 
        public Node() {
            data=null;
        }
        public Node(F newData) {
            data=newData;
        }
    }

    private Node<E> head;
    private int numNodes;

    public LinkedList() {
        head = new Node();
    }


    public int size() {
        return numNodes;
    }

    public boolean add(E e) { //to the end of the list
        Node temp = head;
        if(numNodes==0) {
            head = new Node();
            head.data = e;
            numNodes++;
            return true;
        }
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(e);
        numNodes++;
        return true;
    }

    public void add(int index, E element) { //insert element in specified spot
        Node<E> temp = new Node<>(); 
        if(index == 0) {
            temp.next=head;
            head=temp;
            head.data = element;
            numNodes++;
            return;
        }
        securCheck(index);
        int i = 0;
        Node f = head;
        temp.data = element;
        while(i < index - 1) {
            f = f.next;
        }
        Node holder = f.next;
        f.next = temp;
        temp.next = holder;
        numNodes++;
    }



    @SuppressWarnings("unchecked")
    public E get(int index) {
        securCheck(index);
        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return (E)temp.data;
    }

    public void securCheck(int index){
         if(index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
    }

    @SuppressWarnings("unchecked")
    public E remove(int index) {
       securCheck(index);
        Node temp = head;
        Node holder;
        for(int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = temp.next.next;
        numNodes--;

        return (E)holder.data;
    }

    public boolean remove(Object o) {
        if(head==null || head.data == null) {
            return false;
        }

        if(head.data.equals(o)){
            head=head.next;
            numNodes--;
            return true;
        }
        Node front = head;
        while(front.next!= null) {
            if(front.next.data.equals(o)) {
                front.next=front.next.next;
                numNodes--;
                return true;
            }
            front = front.next;
        }
        return false;
    }

    public E set(int index, E element) { //replace element in specified spot
        securCheck(index);
        Node temp = head;
        E holder;
        for(int i = 0; i < size(); i++) {
            if(i == index) {
                holder = (E)temp.data;
                temp.data = element;
                return holder;
            }
            temp = temp.next;
        }
        throw new IllegalStateException();
    }

    public boolean isEmpty() {
        if(size() == 0) {
            return true;
        }
        return false;
    }

    public boolean contains(Object o) {
        Node temp = head;
        while(temp != null) {
            if(temp.data == o) {
                return true;
            }
        }
        return false;

    }

    private static class LinkedListIterator<F> implements Iterator<F> {
        private Node<F> pointer;
        public LinkedListIterator(Node<F> head) {
            pointer = head;
        }

        public boolean hasNext() {
            return pointer != null;
        }
        public F next() {
            F f = pointer.data;
            pointer = pointer.next;
            return f;
        }
    }

    public Iterator<E> iterator() {//will TODO 
        return new LinkedListIterator<E>(head);
    }

    public void addFirst(E e) {
        if(size() == 0) {
            head.data = e;
            numNodes++;
            return;
        }
       Node newHead=new Node<E>(e);
       newHead.next=head;
       head=newHead;
       numNodes++;
    }

    public void addLast(E e) {
        if(size() == 0) {
            head.data = e;
            numNodes++;
            return;
        }
        Node tra = head;
        while(tra.next != null) {
            tra = tra.next;
        }
        Node temp = new Node<E>(e);
        tra.next = temp;
        numNodes++;
    }

    @SuppressWarnings("unchecked")
    public E getFirst() {
        if(size() == 0) {
            throw new NoSuchElementException();
        }
        return (E)head.data;
    }

    @SuppressWarnings("unchecked")
    public E getLast() {
        if(size() == 0) {
            throw new NoSuchElementException();
        }
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        return (E)temp.data;
    }

    @SuppressWarnings("unchecked")
    public E removeFirst() {
        if(size() == 0) {
            throw new NoSuchElementException();
        }
        E holder = (E)head.data;
        head = head.next;
        numNodes--;
        return holder;

    }
    @SuppressWarnings("unchecked")
    public E removeLast() {
        if(size() == 0) {
            throw new NoSuchElementException();
        }
        Node f = head.next;
        Node r = head;
        while(f.next != null) {
            f = f.next;
            r = r.next;
        }
        r.next = null;
        numNodes--;
        return (E)r.data;
    }

    public boolean offer(E e) { //add element as the tail of the list
        if(size() == 0) {
            head.data = e;
            numNodes++;
            return true;
        }
        addLast(e);
        return true;
    }

    public E element() { //retrives the head of the list
        return getFirst();
    }


    public E peek() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        return getFirst();
    }

    public E poll() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        return removeFirst();
    }

    public E remove() {
        return removeFirst();
    }


    public static void main(String [ ] args) {
        LinkedList<Integer> a = new LinkedList<>();
        printLinkedList(a);

        a.add(1);
        printLinkedList(a);
        a.remove((Integer)1);
        printLinkedList(a);
        a.add(2);
        a.remove((Integer)2);
        printLinkedList(a);


        check(a.size() == 0, "initalize LinkedList size should be 0");

        a.add(0, 2);
        printLinkedList(a);

        a.add(3);
        printLinkedList(a);

        a.add(4);
        check(a.size() == 3, "add 2, 3, 4 in LinkedList");
        printLinkedList(a);

        try {
            a.get(3);
            check(false, "IndexOutOfBoundsException is expected. ");
        } catch (IndexOutOfBoundsException e) {

        }

        a.remove(1);
        check(a.size() == 2, "remove 3, only 2, 4 in the LinkedList");
        printLinkedList(a);

        a.set(0, 3);
        check(a.size() == 2, " reset 2 to 3 in the LinkedList,so list contains 3, 4 ");
        printLinkedList(a);

        a.add(4);
        check(a.size() == 3, " 3, 4 ,4 in the LinkedList");
        printLinkedList(a);

        a.isEmpty();
        check(a.size() != 0, "not empty");

        check(a.contains(3),"contains 3");

        a.addFirst(5);
        check(a.size() == 4, " 5,3, 4 ,4 in the LinkedList");
        a.addLast(6);
        check(a.size() == 5, " 5, 3, 4 , 4, 6 in the LinkedList");
        printLinkedList(a);

        check(a.getFirst()==5,"53446");
        check(a.getLast()==6,"53446");

        a.removeFirst();
        check(a.size() == 4, " 3, 4 , 4, 6 in the LinkedList");
        printLinkedList(a);
        a.removeLast();
        check(a.size() == 3, " 3, 4 ,4 in the LinkList");
        printLinkedList(a);

        a.offer(7);
        check(a.size() == 4, " 3, 4 ,4 ,7 in the LinkList");
        printLinkedList(a);

        check(a.element()==3,"3447");
        check(a.peek()==3,"3447");
        a.remove();
        check(a.size() == 3, " 4 ,4 ,7 in the LinkList");
        printLinkedList(a);//447

        a.poll();//remove the first element
        check(a.size() == 2, " 4, 7 in the LinkList");
        printLinkedList(a);

        check(a.get(0)==4,"index 0,data=4");
        a.remove((Object)4);
        check(a.size()==1,"only 7 in the LinkedList");

        printLinkedList(a);
    }

    public static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    public static void printLinkedList(LinkedList ll) {
        if(ll == null) {
            System.out.println(ll);
            return;
        }
        Node node = ll.head;
        while(node != null) {
            System.out.print(node.data);
            System.out.print(' ');
            node = node.next;
        }
        System.out.println();
    }
}