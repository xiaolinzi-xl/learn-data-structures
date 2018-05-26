package _03_more_about_leetcode;

/**
 * Created by xiaolinzi on 2018/5/21.
 */
public interface Stack<E> {
    boolean isEmpty();

    int getSize();

    void push(E e);

    E pop();

    E peek();
}
