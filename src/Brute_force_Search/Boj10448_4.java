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
public class Boj10448_4 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < testCase; i++) {
            System.out.println(checkUNumber(0,Integer.parseInt(br.readLine()),1));
        }


    }

    public static int checkUNumber(int sum, int targetNumber, int depth) {

        if(depth==3 && sum==targetNumber) {
            return 1;
        }

        for(int i = 1 ; i <=targetNumber/2; i++) {
            if(checkUNumber(sum+(i*(i+1)/2), targetNumber, depth++)==1) {
                return 1;
            };
        }

        return 0;

    }


}
