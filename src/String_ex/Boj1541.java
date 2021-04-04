package String_ex;/*
 * Date : 2021-04-04
 * Question.No : 1541 - 잃어버린괄호
 * Remark :
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj1541 {

    public static void main(String[] args) throws IOException {
        // 더할수있는 모든 수를 더하고 한꺼번에 뺀다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] exp = input.split("-");
        int answer = 0;

        for (int i = 0; i < exp.length; i++) {
            if(exp[i].indexOf("+") != -1) {
                exp[i] = Integer.toString(Arrays.stream(exp[i].split("\\+"))
                        .mapToInt(Integer::parseInt)
                        .sum());
            }
            answer = i == 0 ? Integer.parseInt(exp[i]) : answer - Integer.parseInt(exp[i]);
        }

        System.out.println(answer);

    }
}
