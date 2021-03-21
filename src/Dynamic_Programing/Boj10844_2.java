package Dynamic_Programing;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

/*
 * Date : 21. 03. 13
 * Question.No : 백준 10844 - 쉬운 계단 수
 * Remark :
 */
public class Boj10844_2 {

    public static void main(String[] args) {

        int mod = 1000000000;
        long[] arr = new long[10];
        Arrays.fill(arr, 1, 10, 1);

        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        long sum = 9;
        long lastNumber = arr[0];
        long refNumber = arr[0];

        for (int i = 2; i <= count; i++) {
            lastNumber = arr[0];
            sum = 0;
            for (int j = 0; j < arr.length; j++) {
                if (j >= 1 && j <= 8) {
                    refNumber = arr[j];
                    arr[j] = lastNumber + arr[j + 1];
                    lastNumber = refNumber;
                } else if (j == 0) {
                    arr[j] = arr[j + 1];
                } else {
                    arr[j] = lastNumber;
                }
                arr[j] %= mod;
                sum += arr[j];
            }
        }
        System.out.println(sum % mod);
    }
}
