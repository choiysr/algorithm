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
public class Boj1546 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int subs = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] scores = new double[subs];

        for (int i = 0; i < subs; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }
        final double maxScore = Arrays.stream(scores).max().getAsDouble();
        double avr = Arrays.stream(scores).map(x->(x/maxScore)*100).average().getAsDouble();

        System.out.println(avr);

    }


}
