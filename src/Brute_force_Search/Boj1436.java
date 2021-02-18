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
        int i = 666;

        while(N!=0) {
            if(String.valueOf(i).indexOf("666") > -1){
                N--;
            }
            i++;
        }

        System.out.println(i-1);

    }

}
