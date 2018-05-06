package _07_dynamic_array;

/**
 * Created by xiaolinzi on 2018/5/6.
 */
public class Main {

    public static void main(String[] args) {
        Array<Integer> arr = new Array<>();

        for (int i = 0; i < 10; i++)
            arr.addLast(i);

        // 动态扩容设计存在问题：动荡
        System.out.println(arr.getCapacity());

        arr.addLast(-1);
        System.out.println(arr.getCapacity());

        arr.removeLast();
        System.out.println(arr.getCapacity());
        System.out.println("--------------");

        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);
    }
}
