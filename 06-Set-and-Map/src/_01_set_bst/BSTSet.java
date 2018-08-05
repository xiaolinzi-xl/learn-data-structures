package _01_set_bst;

/**
 * Created by xiaolinzi on 2018/8/5.
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST<E> bst;

    public BSTSet() {
        bst = new BST<>();
    }


    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6, 8, 1, 3, 5, 0, 9, 6};
        BSTSet<Integer> bstSet = new BSTSet<>();
        for (int elm : nums)
            bstSet.add(elm);
        System.out.println(bstSet.getSize());
    }
}
