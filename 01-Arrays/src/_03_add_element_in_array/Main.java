package _03_add_element_in_array;

/**
 * Created by xiaolinzi on 2018/5/6.
 */
public class Main {

    public static void main(String[] args) {
        Array array = new Array();
        array.addFirst(3);
        array.addFirst(4);
        array.addFirst(5);
        array.addFirst(6);
        array.addLast(7);

        System.out.println(array.getSize());
    }
}