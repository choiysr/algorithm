package Brute_force_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Date : 20. 10. 19
 * Question.No : 백준 10448 - 유레카이론
 * URL : https://www.acmicpc.net/problem/10448
 * Remark :
 */
public class Boj10448_3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            System.out.println(checkUnum(Integer.parseInt(br.readLine())));
        }

    }

    public static int checkUnum(int n) {

        int half = n / 2;
        for (int i = 1; i <= half; i++) {
            for (int j = 1; j <= half; j++) {
                for (int k = 1; k <= half; k++) {
                    if (n == (i * (i + 1) / 2) + (j * (j + 1) / 2) + (k * (k + 1) / 2)) {
                        return 1;
                    }
                }
            }
        }

        return 0;
    }


}
