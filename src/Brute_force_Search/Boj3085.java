package Brute_force_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Date : 20. 08. 26
 * Question.No : 백준 3085 - 사탕 게임
 * Remark :
 */
public class Boj3085 {

    // what This class needs
    // [0,0]부터 인접한 노드(최소2개, 최대4개)와 서로 교환하는 메서드
    // 교환이 끝나고 두 사탕의 행,열을 스캔하는 메서드(총 3개줄 - 2열+2행)

    private static char[][] candyBox = null;
    private static int N = 0;
    private static int[] xnodeArr = {0, 0, 1, -1};
    private static int[] ynodeArr = {-1, 1, 0, 0};
    private static int maxCount = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        candyBox = new char[N][N];
        int tmpMax = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                candyBox[i][j] = line.charAt(j);
            }
        }

        // 0,0 부터 인접한 칸과 교환해보자
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                tmpMax = switchEachNode(x, y);
                maxCount = maxCount > tmpMax ? maxCount : tmpMax;
            }
        }

        System.out.println(maxCount);
    }
    // end of main

    // @param : 좌표
    static int switchEachNode(int x, int y) {

        int nextX = 0;
        int nextY = 0;
        int tmpMax = 0;
        int maxOneLine = 0;
        int[] targetLine = new int[2];

        for (int i = 0; i < 4; i++) {
            if (x + xnodeArr[i] < 0 || x + xnodeArr[i] >= N || y + ynodeArr[i] < 0 || y + ynodeArr[i] >= N) {
                continue;
            } else {
                nextX = x + xnodeArr[i];
                nextY = y + ynodeArr[i];

                char tmp = candyBox[nextX][nextY];
                candyBox[nextX][nextY] = candyBox[x][y];
                candyBox[x][y] = tmp;

                // 세로로 교환시 2개의 행 체크 (nodeArr[1]까지는 y축(세로)체크)
                if (i < 2) {
                    targetLine[0] = y;
                    targetLine[1] = nextY;
                    maxOneLine = countCandy(targetLine, true);
                } else { // 가로로 교환시 2개의 열 체크
                    targetLine[0] = x;
                    targetLine[1] = nextX;
                    maxOneLine = countCandy(targetLine, false);
                }

                tmpMax = tmpMax > maxOneLine ? tmpMax : maxOneLine;
                // 끝나고 되돌려야함.
                printarr();
                tmp = candyBox[nextX][nextY];
                candyBox[nextX][nextY] = candyBox[x][y];
                candyBox[x][y] = tmp;
            }
        }

        return tmpMax;

    }
    // end of switchEachNode

    static int countCandy(int[] targetLine, boolean isRow) {

        char startChar = ' ';
        int maxChar = 0;
        int tmpChar = 0;
        //isRow true - 행체크필요 / false - 열체크필요
        if (isRow) { // 행체크
            for (int k = 0; k < targetLine.length; k++) {
                startChar = candyBox[0][targetLine[k]];
                for (int i = 1; i < N; i++) {
                    if (startChar != candyBox[i][targetLine[k]]) {
                        startChar = candyBox[i][targetLine[k]];
                        maxChar = maxChar > tmpChar ? maxChar : tmpChar;
                        tmpChar = 0;
                    } else {
                        tmpChar++;
                    }
                }
            }
        } else { // 열체크
            for (int k = 0; k < targetLine.length; k++) {
                startChar = candyBox[targetLine[k]][0];
                for (int i = 1; i < N; i++) {
                    if (startChar != candyBox[targetLine[k]][i]) {
                        startChar = candyBox[targetLine[k]][i];
                        maxChar = maxChar > tmpChar ? maxChar : tmpChar;
                        tmpChar = 0;
                    } else {
                        tmpChar++;
                    }
                }
            }

        }
        return maxChar;
    }
    // end of checkAmount


    static void printarr() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(candyBox[i][j]+",");
            }
            System.out.println();
        }

    }


}


