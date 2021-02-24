package Dynamic_Programing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Date : 21. 02. 23
 * Question.No : 백준 1463 - 1로 만들기
 * Remark : ***************************틀림. 미완성. 수정해야함!!!!!!!!!!!!!2/25이후로 꼭 수정할것 
 *
570 // 정답: 8
571 // 정답: 9
572 // 정답: 10
642 // 정답: 10
643 // 정답: 11
734 // 정답: 9
740 // 정답: 9
842 // 정답: 11
 */
public class Boj1463_3 {

    private static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 1 || n == 2 || n == 3) {
            System.out.println(n / 2);
            return;
        }

        arr = new int[n + 1][3];
        arr[2][1] = 1;
        arr[3][0] = 1;

        for (int i = 4; i < n + 1; i++) {

            if(i==570);

            if (i % 2 == 0 && i % 3 == 0) {
                arr[i][0] = arr[i / 3][0] + 1;
                arr[i][1] = arr[i / 3][1];
                arr[i][2] = arr[i / 3][2];
            } else if (i % 3 != 0) {
                // -1을 했을 경우 값
                int first = arr[i - 1][0] + arr[i - 1][1] + arr[i - 1][2] + 1;
                // 2로 나눠서 나온 값과 비교
                int second = arr[i / 2][0] + arr[i / 2][1] + arr[i / 2][2] + 1;
                if (first < second) {
                    arr[i][0] = arr[i - 1][0];
                    arr[i][1] = arr[i - 1][1];
                    arr[i][2] = arr[i - 1][2] + 1;
                } else {
                    arr[i][0] = arr[i / 2][0];
                    arr[i][1] = arr[i / 2][1] + 1;
                    arr[i][2] = arr[i / 2][2];
                }
            } else if (i % 3 == 0) {
                // -1을 했을 경우 값
                int first = arr[i - 1][0] + arr[i - 1][1] + arr[i - 1][2] + 1;
                // 3으로로 나눠서 나온 값과 비교
                int second = arr[i / 3][0] + arr[i / 3][1] + arr[i / 3][2] + 1;
                if (first < second) {
                    arr[i][0] = arr[i - 1][0];
                    arr[i][1] = arr[i - 1][1];
                    arr[i][2] = arr[i - 1][2] + 1;
                } else {
                    arr[i][0] = arr[i / 3][0] + 1;
                    arr[i][1] = arr[i / 3][1];
                    arr[i][2] = arr[i / 3][2];
                }
            } else {
                arr[i][0] = arr[i - 1][0];
                arr[i][1] = arr[i - 1][1];
                arr[i][2] = arr[i - 1][2] + 1;
            }

/*            if (i % 2 == 0 && i % 3 == 0) {
                arr[i][0] = arr[3][0] + arr[i/3][0];
                arr[i][1] = arr[i / 3][1];
            } else if (i % 3 == 0) {
                arr[i][0] = arr[3][0] + arr[i/3][0];
            } else if (i % 2 == 0) {
                arr[i][1] = Math.min(arr[i-1][0]+arr[i-1][1]+arr[i-1][2]+1,arr[2][1] + arr[i/2][1]);
            } else {
                arr[i][0] = arr[i - 1][0];
                arr[i][1] = arr[i - 1][1];
                arr[i][2] = arr[i - 1][2] + 1;
            }*/
        }

        System.out.println(arr[n][0] + arr[n][1] + arr[n][2]);


    }
}
