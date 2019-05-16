import java.util.EmptyStackException;
public class Stack<E> extends Vector<E> {
    public E peek() {
        try {//try todo sth if throw exception then catch it hand handle it
            return get(size() - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new EmptyStackException();
        }
    }
    public E pop() {
      try {//try todo sth if throw exception then catch it hand handle it
            return remove(size() - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new EmptyStackException();
        }

    }
    public E push(E item) {
        add(item);
        return item;
    }
    public static void main(String [ ] args) {
        Stack<Integer> stack=new Stack<>();
        stack.add(2);
        printStack(stack);
        stack.add(4);
        printStack(stack);
        stack.add(6);
        printStack(stack);
        stack.add(8);
        printStack(stack);
        stack.peek();
        stack.pop();
        printStack(stack);//2,4,6
        stack.push(10);
        printStack(stack);//2,4,6,10
    }
    public static void printStack(Stack arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i));
            System.out.print(' ');
        }
        System.out.println();
   }
    public static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }


}