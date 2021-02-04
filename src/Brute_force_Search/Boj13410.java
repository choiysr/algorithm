package Brute_force_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Date : 21. 02. 04
 * Question.No : 백준 13410 - 거꾸로 구구단
 * URL : https://www.acmicpc.net/problem/13410
 * Remark : 문자열로 처리해볼것
 */
public class Boj13410 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int maxValue = 0;

        for (int i = 1; i <= k; i++) {
            maxValue = Math.max(maxValue, reverse(n * i));
        }

        System.out.println(maxValue);

    }

    public static int reverse(int org) {
        int square = (int) (Math.pow(10, (int) Math.log10(org)));
        int reversed = 0;
        int remainder = 0;

        while (org != 0) {
            remainder = org % 10;
            org /= 10;
            reversed += remainder * square;
            square /= 10;
        }

        return reversed;
    }


}
