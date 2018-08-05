package _01_set_bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二分搜索树的实现，不包含重复元素
 * Created by xiaolinzi on 2018/8/3.
 */
public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 向二分搜索树添加新元素e
    public void add(E e) {
        root = add(root, e);
    }

    // 向以node为根的二分搜索树中插入新元素e，递归算法
    // 返回新插入节点后二分搜索树的根
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        } else if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        }
        return node;
    }

    // 看二分搜索树是否包含元素e
    public boolean contains(E e) {
        return contains(root, e);
    }

    // 查看以node为根的二分搜索树是否包含元素e,递归算法
    private boolean contains(Node node, E e) {
        if (node == null)
            return false;
        if (e.compareTo(node.e) == 0)
            return true;
        if (e.compareTo(node.e) > 0)
            return contains(node.right, e);
        return contains(node.left, e);
    }

    // 前序遍历
    public void preOrder() {
        preOrder(root);
    }

    // 前序遍历以node为根的二分搜索树，递归算法
    private void preOrder(Node node) {
        if (node == null)
            return;

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 二分搜索树的非递归前序遍历
    public void preOrederNR() {
        if (root == null)
            return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }

    // 二分搜索树的中序遍历
    // 二分搜索树的中序遍历结果是有序的
    public void inOrder() {
        inOrder(root);
    }

    // 以node为根的中序遍历，递归算法
    private void inOrder(Node node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    // 二分搜索树的后序遍历
    public void postOrder() {
        postOrder(root);
    }

    // 以node为根的后序遍历，递归算法
    private void postOrder(Node node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    // 层序遍历
    public void levelOrder() {
        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);

            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
    }

    // 寻找二分搜索树中的最小元素
    public E minimum() {
        if (root == null)
            throw new IllegalArgumentException("_01_set_bst.BST is empty");
        return minimum(root).e;
    }

    // 返回以node为根的二分搜索树的最小值的节点
    private Node minimum(Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    // 寻找二分搜索树中的最大元素
    public E maximum() {
        if (root == null)
            throw new IllegalArgumentException("_01_set_bst.BST is empty");
        return maximum(root);
    }

    // 返回以node为根的二分搜索树的最大值的节点
    private E maximum(Node node) {
        if (node.right == null)
            return node.e;
        return maximum(node.right);
    }

    // 删除最小值所在的节点，并返回最小值
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    // 删除掉以node为根的二分搜索树中的最小值所在节点
    // 返回删除节点后的新的二分搜索树中的根
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    // 删除最大值所在的节点，并返回最小值
    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    // 删除掉以node为根的二分搜索树中的最大值所在节点
    // 返回删除节点后的新的二分搜索树中的根
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    // 从二分搜索树中删除元素为e的节点
    public void remove(E e) {
        root = remove(root, e);
    }

    // 删除掉以node为根的二分搜索树中值为e的节点
    // 返回删除节点后新的二分搜索树的根
    private Node remove(Node node, E e) {
        if (node == null)
            return null;
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // 删除的节点有左右孩子
            // 找到删除节点的右子树中最小值的节点替代删除节点
            Node newNode = minimum(node.right);
            newNode.right = removeMin(node.right);
            newNode.left = node.left;

            node.left = node.right = null;
            return newNode;
        }
    }

    @Override
    public String toString() {
        if (root == null)
            return "";
        // 层序遍历
        LinkedList<Node> list = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        list.addLast(root);
        while (list.size() != 0) {
            Node node = list.removeFirst();
            if (node.left != null)
                list.addLast(node.left);
            if (node.right != null)
                list.addLast(node.right);
            res.append(node.e + " - ");
        }
        return res.toString();
    }


    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
//        bst.add(3);
//        bst.add(4);
//        bst.add(1);
//        System.out.println(bst);
//
//        System.out.println(bst.contains(5)); false

        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums)
            bst.add(num);

        bst.preOrder(); // 5 3 2 4 6 8
        System.out.println();
        bst.inOrder(); // 2 3 4 5 6 8
        System.out.println();
        bst.postOrder(); // 2 4 3 8 6 5
        System.out.println();
        bst.preOrederNR(); // 5 3 2 4 6 8

        System.out.println();
        bst.levelOrder();

        bst.removeMin();
        System.out.println(bst);

        bst.removeMax();
        System.out.println(bst);

        bst.remove(3);
        System.out.println(bst);
    }
}
