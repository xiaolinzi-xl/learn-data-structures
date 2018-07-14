package _04_implement_queue_in_linkedlist;

/**
 * Created by xiaolinzi on 2018/7/14.
 */
public interface Queue<E> {

    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
