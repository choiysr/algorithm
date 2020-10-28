package Dynamic_Programing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * Date : 20. 10. 26
 * Question.No : 백준 16194 - 카드 구매하기2
 * Remark :
 */
public class Boj16194 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cardPack = new int[n + 1];
        int[] minValue = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            cardPack[i] = Integer.parseInt(st.nextToken());
            minValue[i] = cardPack[i];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if(j==1) {
                    minValue[i] = cardPack[j]+minValue[i-j];
                } else {
                    minValue[i] = Math.min(minValue[i],cardPack[j]+minValue[i-j]);
                }

            }
        }

        System.out.println(minValue[n]);


    }
}
