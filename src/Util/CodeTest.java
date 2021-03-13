package Util;

public class CodeTest {

    public static void main(String[] args) {
        test10844();
    }

    public static void test10844() {
        long a = 1;
        System.out.println(a/2);
        System.out.println(Math.ceil(a/2L));
        System.out.println(a/2L);
        System.out.println((long)Math.ceil(a/2.0));
    }
}
