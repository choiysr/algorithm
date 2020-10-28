package Dynamic_Programing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Date : 20. 10. 28
 * Question.No : 백준 1463 - 1로 만들기
 * Remark : 다 갔다가 런타임 뜸.
 */
public class Boj1463_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        arr[1] = 0;
        arr[2] = 1;
        arr[3] = 1;

        for (int i = 4; i <= n; i++) {
            arr[i] = arr[i - 1] + 1;
            if (i % 2 == 0) {
                arr[i] = Math.min(arr[i], arr[2] + arr[i / 2]);
            }
            if (i % 3 == 0) {
                arr[i] = Math.min(arr[i], arr[3] + arr[i / 3]);
            }
        }
        System.out.println(arr[n]);
    }
}