package Brute_force_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Date : 20. 10. 16
 * Question.No : 백준 3085 - 사탕 게임
 * URL : https://www.acmicpc.net/problem/3085
 * Remark :
 */
public class Boj3085_2 {

    private static int size = 0;
    private static char[][] candyBox = null;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        candyBox = new char[size][size];
        int maxCount = 1;

        for (int i = 0; i < size; i++) {
            String line = br.readLine();
            for (int j = 0; j < size; j++) {
                candyBox[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int tmpCount = switchEachCandy(i, j);
                maxCount = tmpCount > maxCount ? tmpCount : maxCount;
            }
        }

        System.out.println(maxCount);
    }


    public static int switchEachCandy(int x, int y) {

        int count = 1;

        // 우측교환
        if (!(y + 1 >= size)) {
            char tmpChar = candyBox[x][y];
            candyBox[x][y] = candyBox[x][y + 1];
            candyBox[x][y + 1] = tmpChar;
            // [2,2]과 [2,3]을 교환했다고 하면
            // 자기줄 가로체크 2번라인 체크  >> [2][0],[2][1]....
            // countRow(x);
            // 원래줄 세로체크 2번라인 체크 >> [0][2], [1][2]....
            // countCul(y);
            // 바꾼줄 세로체크 3번라인 체크 >> [0][3], [1][3]....
            // countCul(y+1);
            count = Math.max(countRow(x), Math.max(countCul(y), countCul(y + 1)));
            candyBox[x][y + 1] = candyBox[x][y];
            candyBox[x][y] = tmpChar;
        }

        // 아래교환
        if (!(x + 1 >= size)) {
            int tmpCount = 0;
            char tmpChar = candyBox[x][y];
            candyBox[x][y] = candyBox[x + 1][y];
            candyBox[x + 1][y] = tmpChar;
            tmpCount = Math.max(countCul(y), Math.max(countRow(x), countRow(x + 1)));
            count = tmpCount > count ? tmpCount : count;
            candyBox[x + 1][y] = candyBox[x][y];
            candyBox[x][y] = tmpChar;
        }
        return count;
    }

    // 가로체크메서드
    public static int countRow(int lineNo) {

        int count = 1;
        int tmpCount = 1;

        for (int i = 0; i < size - 1; i++) {
            if (candyBox[lineNo][i] == candyBox[lineNo][i + 1]) {
                tmpCount++;
            } else {
                count = tmpCount > count ? tmpCount : count;
                tmpCount = 1;
            }
        }
        count = tmpCount > count ? tmpCount : count;
        return count;
    }

    // 세로체크메서드
    public static int countCul(int lineNo) {

        int count = 1;
        int tmpCount = 1;

        for (int i = 0; i < size - 1; i++) {
            if (candyBox[i][lineNo] == candyBox[i + 1][lineNo]) {
                tmpCount++;
            } else {
                count = tmpCount > count ? tmpCount : count;
                tmpCount = 1;
            }
        }
        count = tmpCount > count ? tmpCount : count;
        return count;
    }

}
