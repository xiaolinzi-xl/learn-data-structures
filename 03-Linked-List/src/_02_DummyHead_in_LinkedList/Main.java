package _02_DummyHead_in_LinkedList;

/**
 * Created by xiaolinzi on 2018/7/14.
 */
public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 666);
        System.out.println(linkedList);
    }
}
