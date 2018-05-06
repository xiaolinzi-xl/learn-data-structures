package _04_query_and_update_element;

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
        array.addLast(7);
        array.addLast(8);

        System.out.println(array.get(0));
        System.out.println(array);
        array.set(0, 999);
        System.out.println(array);
    }

}
