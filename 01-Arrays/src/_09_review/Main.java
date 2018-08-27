package _09_review;

public class Main {

    public static void main(String[] args) {
        Array<Integer> array = new Array<>();

        int n = 20;
        for (int i = 0; i < n; i++)
            array.addLast(i);
        System.out.println(array);
        System.out.println(array.getSize());

        for (int i = 0; i < 15; i++) {
            array.removeLast();
            System.out.println(array.getCapacity());
        }
        System.out.println(array);

        System.out.println(array.contains(6));
        System.out.println(array.find(0));

        array.set(0, 4);
        System.out.println(array);
    }
}
