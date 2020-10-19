package Algorithm_Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Date : 20. 10. 13
 * Question.No : 백준 10250 - ACM호텔
 * URL : https://www.acmicpc.net/problem/10250
 * Remark :
 */
public class Boj10250 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int frontNo = 0==N%H ? H : N%H;
            int backNo = 0==N%H ? N/H : N/H+1 ;

            String result = "";

            if(backNo<10) {
                result = sb.append(frontNo).append("0").append(backNo).toString();
            } else {
                result = sb.append(frontNo).append(backNo).toString();
            }

            System.out.println(result);
            sb.setLength(0);

        }

    }

}
