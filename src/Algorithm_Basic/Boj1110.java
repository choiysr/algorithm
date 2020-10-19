package Algorithm_Basic;

import java.io.*;

/*
 * Date : 20. 10. 12
 * Question.No : 백준 1110 - 더하기 사이클
 * URL : https://www.acmicpc.net/problem/1110
 * Remark :
 */
public class Boj1110 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNumber = Integer.parseInt(br.readLine());
        int result = inputNumber;
        int count = 0;

        do {
            result = (result%10)*10 + ((result/10) + (result%10))%10;
            count ++;
        } while(result!=inputNumber);

        System.out.println(count);

    }
}
