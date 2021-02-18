package Dynamic_Programing;

import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

/*
 * Date : 21. 02. 18
 * Question.No : 백준 11057 - 오르막수
 * URL : https://www.acmicpc.net/problem/11057
 * Remark : 두번째 풀이. 문자열로 풀것.
 */
public class Boj11057_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        BigInteger sum = BigInteger.valueOf(10);
        BigInteger[] raisingNumber = new BigInteger[10];
        Arrays.fill(raisingNumber, BigInteger.valueOf(1));

        while (--input > 0) {
            sum = BigInteger.valueOf(0);
            for (int i = 0; i < raisingNumber.length; i++) {
                BigInteger tmpSum = BigInteger.valueOf(0);
                for (int j = i; j < raisingNumber.length; j++) {
                    tmpSum = tmpSum.add(raisingNumber[j]);
                }
                raisingNumber[i] = tmpSum;
                sum = sum.add(tmpSum);
            }
        }

        System.out.println(sum.mod(BigInteger.valueOf(10007)));


    }

}
