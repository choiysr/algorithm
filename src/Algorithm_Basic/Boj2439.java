package Algorithm_Basic;

import Util.TimeChecker;

import java.io.*;
import java.sql.Time;
import java.util.Scanner;

/*
 * Date : 20. 10. 12
 * Question.No : 백준 2439 - 별찍기-2
 * URL : https://www.acmicpc.net/problem/2439
 * Remark :
 */
public class Boj2439 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                bw.write(" ");
            }
            for (int k = 0; k <= i; k++) {
                bw.write("*");
            }
            bw.newLine();
        }

        bw.close();

    }
}
