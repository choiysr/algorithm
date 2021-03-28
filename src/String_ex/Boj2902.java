package String_ex;/*
 * Date : 2021-03-28
 * Question.No :
 * Remark :
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Boj2902 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] original = br.readLine().split("");

        String answer = original[0];
        answer += IntStream.range(1,original.length).filter(idx -> original[idx-1].equals("-"))
                .mapToObj(idx -> original[idx]).collect(Collectors.joining());
        System.out.println(answer);

    }

}
