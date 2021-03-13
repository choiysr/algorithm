package Dynamic_Programing;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

/*
 * Date : 21. 03. 02
 * Question.No : 백준 10844 - 쉬운 계단 수
 * Remark :
 */
public class Boj10844_2 {

    public static void main(String[] args) {

        long[] arr = new long[10];
        Arrays.fill(arr, 1, 10, 1);
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        long sum = 9;
        long refNumber = arr[0];
        long lastNumber = arr[0];
        for (int i = 2; i <= count; i++) {
            lastNumber = arr[0];
            sum = 0;
            for (int j = 0; j < arr.length; j++) {
                if (j >= 2 && j <= 7) {
                    refNumber = arr[j];
                    arr[j] = (long) Math.ceil(lastNumber / 2.0) + (long) Math.ceil(arr[j + 1] / 2.0);
                    lastNumber = refNumber;
                } else if (j == 0) {
                    arr[j] = arr[j + 1];
                } else if (j == 8) {
                    refNumber = arr[j];
                    arr[j] = (long) Math.ceil(arr[j - 1] / 2.0) + lastNumber;
                    lastNumber = refNumber;
                } else if (j == 9) {
                    arr[j] = (long) Math.ceil(lastNumber / 2.0);
                } else {
                    refNumber = arr[j];
                    arr[j] = lastNumber + (long) Math.ceil(arr[j + 1] / 2.0);
                    lastNumber = refNumber;
                }
                sum += arr[j];
            }
            // after arr[0] = before arr[1]
            // after arr[1] = before arr[0] + before arr[2]/2
            // after arr[n] = before arr[n-1]/2 + before arr[n+1]/2
            // after arr[8] = before arr[7]/2 + before arr[9];
            // after arr[0] = before arr[8]/2
        }
        System.out.println(sum % 1000000000);
    }
}
