package String_ex;/*
 * Date : 2021-04-05
 * Question.No :
 * Remark :
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj5525 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M;
    private static char[] input;

    static {
        try {
            N = lineToInt();
            M = lineToInt();
            input = br.readLine().toCharArray();
        } catch (IOException e) {

        }
    }

    public static void main(String[] args) {

        int count = 0;
        int patternCount = 0;

        for (int i = 1; i < input.length - 1; i++) {
            if(input[i-1] == 'I' && input[i] == 'O' && input[i+1] == 'I') {
                patternCount++;
                if(patternCount == N) {
                    patternCount--;
                    count++;
                }
                i++;
            } else {
                patternCount = 0;
            }
        }


        System.out.println(count);


    }


    private static int lineToInt() throws IOException {
        return Integer.parseInt(br.readLine());
    }

}


