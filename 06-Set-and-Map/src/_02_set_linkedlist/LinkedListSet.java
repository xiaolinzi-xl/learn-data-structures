package _02_set_linkedlist;


import _01_set_bst.Set;

/**
 * Created by xiaolinzi on 2018/8/5.
 */
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> list;

    public LinkedListSet() {
        list = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if (!list.contains(e))
            list.addFirst(e);
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    public LinkedList getList() {
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 7, 4, 3, 4};
        LinkedListSet<Integer> linkedListSet = new LinkedListSet<>();

        for (int num : nums) {
            linkedListSet.add(num);
        }

        System.out.println(linkedListSet.getList());
        linkedListSet.remove(3);
        System.out.println(linkedListSet.getList());
    }
}
