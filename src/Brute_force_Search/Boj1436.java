package Brute_force_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Date : 21. 02. 15
 * Question.No : 백준 1436 - 영화감독 숌
 * URL : https://www.acmicpc.net/problem/1436
 * Remark :
 */
public class Boj1436 {

    private static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int count = 0;


        for(int i = 666; i <= 10000666; i++) {
            if(contains666(i)) {
                count++;
            }

            if(count==N) {
                System.out.println(i);
                break;
            }
        }
    }


    public static boolean contains666(int number) {

        String fullNumber = String.valueOf(number);
        return fullNumber.contains("666");

    }

}
