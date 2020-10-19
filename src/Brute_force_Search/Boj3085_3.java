package Brute_force_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Date : 20. 10. 19
 * Question.No : 백준 3085 - 사탕 게임
 * URL : https://www.acmicpc.net/problem/3085
 * Remark :
 */
public class Boj3085_3 {

    private static int N = 0;
    private static char[][] box = null;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        box = new char[N][N];
        int result = 1;

        for (int i = 0; i < N; i++) {
            String eachLine = br.readLine();
            for (int j = 0; j < N; j++) {
                box[i][j] = eachLine.charAt(j);
            }
        }

        // 1. 오른쪽, 아래만 switch(사방 변경 필요 X)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result = Math.max(result,switchCandies(i, j));
            }
        }

        System.out.println(result);
    }

    public static int switchCandies(int x, int y) {

        char tmp = box[x][y];
        int maxFirst = 1;
        int maxSecond = 1;

        // 오른쪽[0,1]과 아래[1,0]만 변경 - 조건 추가해야함.
        // 오른쪽과 변경하는 경우
        if (y + 1 < N) {
            box[x][y] = box[x][y + 1];
            box[x][y + 1] = tmp;
            maxFirst = Math.max(checkRow(x), Math.max(checkCul(y), checkCul(y + 1)));
            // 원복
            box[x][y + 1] = box[x][y];
            box[x][y] = tmp;
        }
        // 아래와 변경하는 경우
        if (x + 1 < N) {
            box[x][y] = box[x + 1][y];
            box[x + 1][y] = tmp;
            maxSecond = Math.max(checkCul(y), Math.max(checkRow(x), checkRow(x + 1)));
            // 원복
            box[x + 1][y]= box[x][y];
            box[x][y] = tmp;
        }

        return Math.max(maxFirst,maxSecond);
    }


    // 가로(행) 검사
    public static int checkRow(int xLine) {

        int count = 1;
        int tmpCount = 1;

        for (int i = 0; i < N - 1; i++) {
            if (box[xLine][i] == box[xLine][i + 1]) {
                tmpCount++;
            } else {
                count = Math.max(count, tmpCount);
                tmpCount = 1;
            }
            count = Math.max(count, tmpCount);
        }

        return count;
    }

    // 세로(열) 검사
    public static int checkCul(int yLine) {

        int count = 1;
        int tmpCount = 1;

        for (int i = 0; i < N - 1; i++) {
            if (box[i][yLine] == box[i + 1][yLine]) {
                tmpCount++;
            } else {
                count = Math.max(count, tmpCount);
                tmpCount = 1;
            }
            count = Math.max(count, tmpCount);
        }

        return count;
    }

}
