package Dynamic_Programing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Date : 21. 02. 24
 * Question.No : 백준 2839 - 설탕배달
 * Remark : DP로 풀어야 하는뎅...ㅠㅠ
 */
public class Boj2839 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sugar = Integer.parseInt(br.readLine());
        int mod5 = sugar % 5;

            if (4 == sugar || 7 == sugar) {
                System.out.println(-1);
            } else if (0 == mod5) {
                System.out.println(sugar / 5);
            } else if (1 == mod5 || 3 == mod5) {
                System.out.println(sugar / 5 + 1);
            } else if (2 == mod5 || 4 == mod5) {
            System.out.println(sugar / 5 + 2);
        } else {
            System.out.println(sugar / 3);
        }

    }
}
