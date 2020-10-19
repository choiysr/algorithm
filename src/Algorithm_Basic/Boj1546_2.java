package Algorithm_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * Date : 20. 10. 15
 * Question.No : 백준 1546 - 평균
 * URL : https://www.acmicpc.net/problem/1546
 * Remark :
 */
public class Boj1546_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int subs = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] scores = new double[subs];
        double sumValue = 0, maxScore = 0;

        for (int i = 0; i < subs; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
            maxScore = maxScore < scores[i] ? scores[i] : maxScore;
        }

        for (int i = 0; i < subs; i++) {
            scores[i] = (scores[i]/maxScore) * 100;
            sumValue += scores[i];
        }
        System.out.println(sumValue/subs);

    }


}
