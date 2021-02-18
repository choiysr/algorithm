package Dynamic_Programing;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Date : 21. 02. 18
 * Question.No : 백준 11057 - 오르막수
 * URL : https://www.acmicpc.net/problem/11057
 * Remark : 틀림. numberFormat Exaption. N값이 1000까지인데 int로는 한계가 있음.
 */
public class Boj11057 {

    private static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int count = 10;

        if (N == 1) {
            System.out.println(count);
            return;
        }

        for (int i = 0; i < N; i++) {
            sb.append("1");
        }

        int orgNumber = Integer.parseInt(sb.toString());
        int number = orgNumber;
        int limit = orgNumber * 9;

        for (int i = 11; i <= limit; i++) {
            if (isRight(i)) {
                count++;
            }
        }

        System.out.println(count);


    }


    public static boolean isRight(int number) {

        int length = (int)Math.floor(Math.log10(number))+1;
        int decim = (int) Math.pow(10, Math.floor(Math.log10(number)));
        int target = number / decim;
        boolean result = true;

        number = number % decim;
        decim /= 10;

        for (int i = 1; i < length; i++) {
            if (target > number / decim) {
                result = false;
                break;
            } else {
                target = number / decim;
                number = number % decim;
                decim /= 10;
            }
        }

        return result;

    }


}
