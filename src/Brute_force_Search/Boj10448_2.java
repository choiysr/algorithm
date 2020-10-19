package Brute_force_Search;

import java.io.*;

/*
 * Date : 20. 10. 15
 * Question.No : 백준 10448 - 유레카 이론
 * URL : https://www.acmicpc.net/problem/10448
 * Remark : 속도 빠른 남의 코드. 공부할것
 */
public class Boj10448_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[][] table = new boolean[3][1001];
        int u;
        for (int i = 1; (u = i * (i + 1) / 2) < 1000; i++) {
            table[0][u] = true;

            for (int j = 1; j <= 2; j++) {
                for (int k = u + 1; k <= 1000; k++) {
                    if (table[j - 1][k - u]) table[j][k] = true;
                }
            }
        }

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (table[2][num]) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }


}
