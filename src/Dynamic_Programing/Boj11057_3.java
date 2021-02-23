package Dynamic_Programing;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * Date : 21. 02. 18
 * Question.No : 백준 11057 - 오르막수
 * URL : https://www.acmicpc.net/problem/11057
 * Remark : 세번째 풀이. long이용. 배열에 저장시 처음부터 나머지값을 저장.
 */
public class Boj11057_3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        long sum = 10;
        long[] raisingNumber = new long[10];
        Arrays.fill(raisingNumber, 1);


        while (--input > 0) {
            sum = 0;
            for (int i = 0; i < raisingNumber.length; i++) {
                long tmpSum = 0;
                for (int j = i; j < raisingNumber.length; j++) {
                    tmpSum += raisingNumber[j];
                }
                raisingNumber[i] = tmpSum%10007;
                sum+=tmpSum;
            }
        }

        System.out.println(sum%10007);

    }

}
