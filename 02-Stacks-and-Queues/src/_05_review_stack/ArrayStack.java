package _05_review_stack;

public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    public ArrayStack() {
        array = new Array<>();
    }

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: [");

        for (int i = array.getSize() - 1; i >= 0; i--) {
            if (i != 0)
                sb.append(array.get(i) + " , ");
            else
                sb.append(array.get(i) + "]");
        }

        return sb.toString();
    }
}
