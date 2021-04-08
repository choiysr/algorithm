package String_ex;/*
 * Date : 2021-04-08
 * Question.No :
 * Remark :
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj5598 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(encode(br.readLine()));
    }


    private static String encode(String original) {

        char[] charArr = original.toCharArray();
        StringBuilder sb = new StringBuilder();

        for(char each : charArr) {
            if((int)each <= 67) {
                sb.append((char)(each+23));
            } else {
                sb.append((char)(each-3));
            }
        }

        // each + (X)  >> X가 +23이 나오거나 -3이 나와야 함. X는 입력받는 수에 의해 정해짐
        // +23이 나오는 경우는 3보다 작거나 같을때
        // -3이 나오는 경우는 3보다 클때

        //

        return sb.toString();
    }

}
