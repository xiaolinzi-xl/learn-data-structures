package _05_review_stack;

public class Array<E> {

    private E[] data;

    private int size;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        if (data == null)
            throw new NullPointerException("Array is null.");
        return data.length;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++)
            newData[i] = data[i];
        data = newData;
    }

    // 在索引index位置插入元素e
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Index is invalid.");

        if (size == data.length)
            resize(2 * data.length);
        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];
        data[index] = e;
        size++;
    }

    // 在数组末尾添加元素e
    public void addLast(E e) {
        add(size, e);
    }

    // 在数组头部添加元素e
    public void addFirst(E e) {
        add(0, e);
    }

    // 删除索引位置为index的元素，并返回删除元素
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Index is invalid.");

        E res = data[index];
        for (int i = index + 1; i < size; i++)
            data[i - 1] = data[i];
        size--;
        data[size] = null;

        if (size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return res;
    }

    // 删除末尾元素
    public E removeLast() {
        return remove(size - 1);
    }

    // 删除首部元素
    public E removeFirst() {
        return remove(0);
    }

    // 数组是否包含元素e
    public boolean contains(E e) {
        for (int i = 0; i < size; i++)
            if (data[i].equals(e))
                return true;

        return false;
    }

    // 数组是否包含元素e，如果包含，返回第一次出现的索引位置，不包含返回-1
    public int find(E e) {
        for (int i = 0; i < size; i++)
            if (data[i].equals(e))
                return i;

        return -1;
    }

    // 移除元素e
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Index is invalid.");
        data[index] = e;
    }

    // 获取索引为index的元素
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Index is invalid");
        return data[index];
    }

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++)
            if (i != size - 1)
                sb.append(data[i] + " , ");
            else
                sb.append(data[i] + "]");

        return sb.toString();
    }
}
