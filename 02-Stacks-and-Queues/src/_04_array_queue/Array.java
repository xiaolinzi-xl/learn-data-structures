package _04_array_queue;

/**
 * Created by xiaolinzi on 2018/5/21.
 */
public class Array<E> {

    private E[] data; // 存储数组
    private int size; // 数组的元素的个数

    // 构造函数，传入数组容量capacity构造array
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    // 空参构造函数，默认容量为10
    public Array() {
        this(10);
    }

    // 获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    // 返回数组元素的个数
    public int getSize() {
        return size;
    }

    // 判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 将元素e插入指定位置 index的范围为0-size,即索引位置
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed.Require index >= 0 and index <= size");
        if (size == data.length) {
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];
        data[index] = e;
        size++;
    }

    // 在所有元素前面插入元素e
    public void addFirst(E e) {
        add(0, e);
    }

    // 在所有元素后面插入元素e
    public void addLast(E e) {
        add(size, e);
    }

    // 获取指定索引的元素 index范围在0-size-1
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed.Require index >= 0 and index < size");
        return data[index];
    }

    // 获取数组中第一个元素
    public E getFirst() {
        return get(0);
    }

    // 获取末尾元素
    public E getLast() {
        return get(size - 1);
    }

    // 设置索引index的元素为e，index的范围是0-size-1
    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed.Required index >= 0 and index < size");
        data[index] = e;
    }

    // 查找元素中是否有元素e
    public boolean contains(E e) {
        for (E element : data)
            if (element == e)
                return true;
        return false;
    }

    // 查找数组元素e的索引，若不存在则返回-1
    public int find(E e) {
        for (int i = 0; i < size; i++)
            if (data[i] == e)
                return i;
        return -1;
    }

    // 从数组中删除索引index对应的元素，返回删除元素的值
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed.Index required >= 0 and < size");
        E result = data[index];

        for (int i = index + 1; i < size; i++)
            data[i - 1] = data[i];
        size--;
        data[size] = null; // gc 回收

        if (size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);

        return result;
    }

    // 移除数组中的第一个元素
    public E removeFirst() {
        return remove(0);
    }

    // 移除数组中最后一个元素
    public E removeLast() {
        return remove(size - 1);
    }

    // 从数组中删除元素e
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    // 将数组空间的容量变成capacity大小
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++)
            newData[i] = data[i];
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append("[");

        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1)
                res.append(",");
        }
        res.append("]");
        return res.toString();
    }
}
