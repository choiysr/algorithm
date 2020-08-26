package Brute_force_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * Date : 20. 08. 26
 * Question.No : 백준 2309 - 일곱난쟁이
 * Remark :
 */
public class Boj2309 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numArr = new int[9];
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            numArr[i] = Integer.parseInt(br.readLine());
            sum += numArr[i];
        }

        Loop : for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(i!=j && (sum - (numArr[i] + numArr[j])==100)) {
                    numArr[i] = 0;
                    numArr[j] = 0;
                    break Loop;
                }
            }
        }

        Arrays.sort(numArr);

        for(int i = 2; i < 9; i++) {
            System.out.println(numArr[i]);
        }

    }
}
