import java.util.NoSuchElementException;
@SuppressWarnings("unchecked")
public class LinkList<E> implements List<E>, Deque<E> {
    private static class Node<F> {
        private Node next;
        private F data;
    }

    private Node<E> head;
    private int numNodes;

    public LinkList() {
        head=new Node();
    }


    public int size() {
        return numNodes;
    }

     public boolean add(E e) {//to the end of the list
        Node temp=head;
        if(size()==0) {
            head.data=e;
            numNodes++;
            return true;
        }
        while(temp.next!=null) {
            temp=temp.next;
        }
        temp.next=new Node();
        temp.next.data=e;
        numNodes++;
        return true;
    }

    public void add(int index, E element) {//insert element in specified spot
        if(index<0||index>size()) {
            throw new IndexOutOfBoundsException(); 
        }
        if(index==0) {
            head.data=element;
            numNodes++;
            return;
        }
        int i=0;
        Node f=head;
        Node n=new Node<E>();
        n.data=element;
        while(i<index-1){
            f=f.next;
        }
        Node holder=f.next;
        f.next=n;
        n.next=holder;
        numNodes++;
   }
    


    @SuppressWarnings("unchecked")
    public E get(int index) {
        if(index<0||index>=size()) {
            throw new IndexOutOfBoundsException();
        }
        Node temp=head;
        for(int i=0;i<index;i++) {
            temp=temp.next;
        }
        return (E)temp.data;
    }

    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if(index<0||index>=size()) {
            throw new IndexOutOfBoundsException();
        }
        Node temp=head;
        Node holder;
        for(int i=0;i<index-1;i++) {
            temp=temp.next;
        }
        holder=temp.next;
        temp.next=temp.next.next;
        numNodes--;
        return (E)holder.data;
    }

    public boolean remove(Object o) {
        Node temp=head;
        while(temp!=null) {
            if(temp.data==o){
                return true;
            }
            temp=temp.next;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public E set(int index, E element) {//replace element in specified spot
        if(index<0||index>=size()) {
            throw new IndexOutOfBoundsException();
        }
        Node temp=head;
        E holder;
        for(int i=0;i<size();i++) {
            if(i==index){
                holder=(E)temp.data;
                temp.data=element;
                return (E)holder;
            }
            temp=temp.next;
        }
        throw new IllegalStateException();
    }

       public boolean isEmpty() {
        if(size()==0){
            return true;
        }
        return false;
    }

     public boolean contains(Object o) {
        Node temp=head;
        while(temp!=null){
            if(temp.data==o) {
                return true;
            }
        }
        return false;

     }

      public Iterator<E> iterator() {
        return null;
    }  

    public void addFirst(E e) {
        if(size()==0){
            head.data=e;
            numNodes++;
            return;
        }
        Node holder=new Node<E>();
        holder.data=head.data;
        holder.next=head.next;
        head.data=e;
        head.next=holder;
        numNodes++;
    }

    public void addLast(E e) {
        if(size()==0){
            head.data=e;
            numNodes++;
            return;
        }
        Node tra=head;
        while(tra.next!=null) {
            tra=tra.next;
        }
        Node temp=new Node<E>();
        temp.data=e;
        tra.next=temp;
        numNodes++;
    }

    @SuppressWarnings("unchecked")
    public E getFirst() {
        if(size()==0){
            return null;
        }
        return (E)head.data;
    }

    @SuppressWarnings("unchecked")
    public E getLast() {
        if(size()==0){
            return null;
        }
        Node temp=head;
        while(temp.next!=null) {
            temp=temp.next;
        }
        return (E)temp.data;
    }

    @SuppressWarnings("unchecked")
    public E removeFirst() {
        if(size()==0){
            throw new NoSuchElementException();
        }
        E holder=(E)head.data;
        head=head.next;
        numNodes--;
        return holder;
        
    }

    public E removeLast() {
        if(size()==0){
            throw new NoSuchElementException();
        }
        Node f=head.next;
        Node r=head;
        while(f.next!=null) {
            f=f.next;
            r=r.next;
        }
        r.next=null;
        numNodes--;
        return (E)r.data;
    }

    public boolean offer(E e) {//add element as the tail of the list
        if(size()==0){
            head.data=e;
            numNodes++;
            return true;
        }
        addLast(e);
        return true;
    }

    public E element() {//retrives the head of the list
        return getFirst();
    }


    public E peek() {
        if(isEmpty()) {
            return null;
        }
        return getFirst();
    }

    public E poll() {
        if(isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    public E remove() {
        return removeFirst();
    }


    public static void main(String [ ] args) {
        LinkList<Integer> a=new LinkList<>();
        a.size();
        check(a.size()==0,"initalize LinkList size should be 0");

        a.add(0,2);
        printLinkList(a);

        a.add(3);
        printLinkList(a);

        a.add(4);
        check(a.size()==3,"add 2, 3, 4 in LinkList");
        printLinkList(a);

        try {
            a.get(3);
            check(false,"IndexOutOfBoundsException is expected. ");
        } catch (IndexOutOfBoundsException e) {

        }

        a.remove(1);
        check(a.size()==2,"remove 3, only 2, 4 in the LinkList");
        printLinkList(a);

        a.set(0,3);
        check(a.size()==2," reset 2 to 3 in the LinkList,so list contains 3, 4 ");
        printLinkList(a);

        a.add(4);
        check(a.size()==3," 3, 4 ,4 in the LinkList");
        printLinkList(a);

        a.isEmpty();
        check(a.size()!=0,"not empty");
        
        a.contains(3);
        printLinkList(a);

        a.addFirst(5);
        check(a.size()==4," 5,3, 4 ,4 in the LinkList");
        a.addLast(6);
        check(a.size()==5," 5, 3, 4 , 4, 6 in the LinkList");
        printLinkList(a);

        a.getFirst();
        a.getLast();

        a.removeFirst();
        check(a.size()==4," 3, 4 , 4, 6 in the LinkList");
        printLinkList(a);
        a.removeLast();
        check(a.size()==3," 3, 4 ,4 in the LinkList");
        printLinkList(a);

        a.offer(7);
        check(a.size()==4," 3, 4 ,4 ,7 in the LinkList");
        printLinkList(a);
        a.element();
        a.peek();
        a.remove();
        check(a.size()==3," 4 ,4 ,7 in the LinkList");
        a.poll();//remove the first element
        check(a.size()==2," 4, 7 in the LinkList");
        printLinkList(a);
     }

    public static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    public static void printLinkList(LinkList ll){
        Node node = ll.head;
        while(node!=null){
            System.out.print(node.data);
            System.out.print(' ');
            node=node.next;
        }
        System.out.println();
    }
}