package String_ex;/*
 * Date : 2021-04-05
 * Question.No :
 * Remark :
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj5525 {

    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        String input = br.readLine();

        StringBuilder sb = new StringBuilder();
        sb.append("I");
        for (int i = 0; i < N * 2; i++) {
            if (i == 0 || i % 2 == 0) {
                sb.append("O");
            } else {
                sb.append("I");
            }
        }

        String pn = sb.toString();
        int count = 0;

        for (int i = 0; i < M; i++) {
            if (input.charAt(i) == 'I' && i+pn.length()<=input.length()) {
                if (input.substring(i, pn.length()+i).equals(pn)) {
                    count++;
                }
            }
        }

        System.out.println(count);

    }
}


