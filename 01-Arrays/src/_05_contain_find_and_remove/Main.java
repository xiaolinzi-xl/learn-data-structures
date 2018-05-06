package _05_contain_find_and_remove;

/**
 * Created by xiaolinzi on 2018/5/6.
 */
public class Main {

    public static void main(String[] args) {
        Array array = new Array();

        array.addLast(3);
        array.addLast(4);
        array.addLast(5);
        array.addLast(6);

        System.out.println(array.contains(7));
        System.out.println(array.find(3));
        System.out.println(array);

        array.removeElement(3);
        System.out.println(array);
    }
}
