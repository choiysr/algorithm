package Dynamic_Programing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Date : 21. 02. 23
 * Question.No : 백준 1463 - 1로 만들기
 * Remark : 맞았습니다
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

            if (i % 2 == 0 && i % 3 == 0) {
                // 2로 나누는 경우와 3으로 나누는 경우를 비교.
                if (getElementByIndex(i,2) < getElementByIndex(i,3)) {
                    setArray(i, 2);
                } else {
                    setArray(i, 3);
                }
            } else if (i % 2 == 0) {
                // 1을 빼는 경우와 2로 나누는 경우를 비교.
                if (getElementByIndex(i,1) < getElementByIndex(i,2)){
                    setArray(i, 1);
                } else {
                    setArray(i, 2);
                }
            } else if (i % 3 == 0) {
                // 1을 빼는 경우와 3으로 나누는 경우를 비교.
                if (getElementByIndex(i,1) < getElementByIndex(i,3)) {
                    setArray(i, 1);
                } else {
                    setArray(i, 3);
                }
            } else {
                setArray(i, 1);
            }

        }

        System.out.println(arr[n][0] + arr[n][1] + arr[n][2]);

    }

    public static int getElementByIndex(int index, int computingTarget) {

        int target = computingTarget == 3 ? index / 3 : computingTarget == 2 ? index / 2 : index - 1;
        return arr[target][0] + arr[target][1] + arr[target][2];

    }

    public static void setArray(int index, int computingTarget) {

        int target = computingTarget == 3 ? index / 3 : computingTarget == 2 ? index / 2 : index - 1;

        for (int i = 0; i < 3; i++) {
            arr[index][i] = computingTarget + i == 3 ? arr[target][i]+1 : arr[target][i];
        }

    }

}
