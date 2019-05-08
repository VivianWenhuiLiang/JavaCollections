public class LinkList<E> implements List<E>, Deque<E> {
    private static Node head;
    private static int numNodes;
    public LinkList() {
        head=new Node()；
    }
    public class Node {
        private Node next;
        private E data;
    }

   public int size() {
    return numNodes;
   }

   public void add(int index, E element) {
    if(index<0||index>=size()) {
        throw new IndexOutOfBoundsException(); 
    }
    int i=0;
    if(index==0&&head.next==null) {
        head.data=element;
    }
    Node back=head;
    Node front;
    while(i<index-1) {
        back=back.next;
        i++;
    }
    front=back.next;
    back.next=new Node();
    back.next.data=element;
    back.next.next=front;
    numNodes++;
   }
    

    public E get(int index) {
        if(index<0||index>=size()) {
            throw new IndexOutOfBoundsException();
        }
        Node temp=head;
        for(int i=0;i<index;i++) {
            temp=temp.next;
        }
        return temp.data;
    }

    public E remove(int index) {
        if(index<0||index<=size()) {
            throw new IndexOutOfBoundsException();
        }
        Node temp=head;
        Node holder;
        for(int i=0;i<index-1;i++) {
            temp=temp.next;
        }
        holder=temp.next;
        temp.next=temp.next.next;
        return holder.data;
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

    public E set (int index, E element) {
        if(index<0||index>=size()) {
            throw new IndexOutOfBoundsException();
        }
        Node temp=head;
        E holder;
        for(int i=0;i<size();i++) {
            if(i==index){
                holder=temp.data;
                temp.data=element;
                return holder;
            }
            temp=temp.next;
        }
    }

    public boolean add(E e) {//to the end of the list
        Node temp=head;
        if(size()==0) {
            head.data=e;
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

       public boolean isEmpty() {
        if(size()==0){
            return ture;
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

     public static void main(String [ ] args) {
        ArrayList a=new LinkList();
        a.size();
        check(aL.size()==0,"initalize LinkList size should be 0");

        a.add(0,1);
        printLinkList(a);
        a.add(1.2);
        printLinkList(a);
        a.add(2,3);
        check(a.size==3,"add 1, 2, 3 in LinkList");
        printLinkList(a);

        a.get(3);
        a.remove(1);
        check(a.size==2,"remove 2, only 1, 3 in the LinkList");
        printLinkList(a);

        remove(3);
        check(a.size()==1,"only 1 left in the LinkList");
        printLinkList(a);

        a.set(0,3);
        check(a.size()==1," reset 1 to 3 in the LinkList");
        printLinkList(a);

        a.add(4);
        check(a.size()==2," 3, 4 in the LinkList");
        printLinkList(a);

        a.isEmpty();
        check(a.size()!=0,"not empty");
        
        a.contains(3);
        printLinkList(a);




     }

    public static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    public static void printLinkList(LinkList a){
        while(a!=null){
            System.out.print(a.data);
            System.out.print(' ');
            a=a.next;
        }
        System.out.println();
    }
 
}