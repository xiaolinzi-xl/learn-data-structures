package _01_array_stack;

/**
 * Created by xiaolinzi on 2018/5/7.
 */
public interface Stack<E> {
    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}
