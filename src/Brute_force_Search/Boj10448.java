package Brute_force_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Date : 20. 10. 15
 * Question.No : 백준 10448 - 유레카 이론
 * URL : https://www.acmicpc.net/problem/10448
 * Remark :
 */
public class Boj10448 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        for(int i = 0; i < K; i++) {
            System.out.println(isTrue(Integer.parseInt(br.readLine())));
        }

    }

    public static int getUnumber(int n) {
        return n * (n + 1) / 2;
    }

    public static int isTrue(int targetNumber) {

        int halfOfTarget = targetNumber / 2;
        int result = 0;

        Loop:
        for (int i = 1; i <= halfOfTarget; i++) {
            for (int j = 1; j <= halfOfTarget; j++) {
                for (int k = 1; k <= halfOfTarget; k++) {
                    if (targetNumber == getUnumber(i) + getUnumber(j) + getUnumber(k)) {
                        result = 1;
                        break Loop;
                    }
                }
            }
        }

        return result;

    }

}
