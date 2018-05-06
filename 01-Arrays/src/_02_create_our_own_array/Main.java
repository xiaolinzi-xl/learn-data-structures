package _02_create_our_own_array;

/**
 * Created by xiaolinzi on 2018/5/6.
 */
public class Main {

    public static void main(String[] args) {
        Array array = new Array(20);
        System.out.println(array.getCapacity());
        System.out.println(array.getSize());
        System.out.println(array.isEmpty());
        System.out.println("------------");

        Array array1 = new Array();
        System.out.println(array1.getCapacity());
    }
}
