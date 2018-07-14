package _03_implement_stack_in_linkedlist;

/**
 * Created by xiaolinzi on 2018/7/14.
 */
public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
