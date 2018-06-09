package _04_array_queue;

/**
 * Created by xiaolinzi on 2018/5/26.
 */
public interface Queue<E> {

    void enqueue(E e);

    E dequeue();

    E getFront();

    int getSize();

    boolean isEmpty();

}
