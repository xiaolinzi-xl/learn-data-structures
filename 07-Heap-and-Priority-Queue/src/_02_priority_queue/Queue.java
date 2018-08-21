package _02_priority_queue;

/**
 * Created by xiaolinzi on 2018/8/21.
 */
public interface Queue<E> {
    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();
}
