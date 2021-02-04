package Algorithm_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Date : 21. 02. 03
 * Question.No : 백준 14681 - 사분면 고르기
 * URL : https://www.acmicpc.net/problem/14681
 * Remark :
 */
public class Boj14681 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int first = Integer.parseInt(br.readLine());
        int second = Integer.parseInt(br.readLine());
        System.out.println(first > 0 ? (second > 0 ? 1 : 4) : (second > 0 ? 2: 3));

    }
}
