package Brute_force_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Date : 20. 08. 26
 * Question.No : 백준 3085 - 사탕 게임
 * URL : https://www.acmicpc.net/problem/3085
 * Remark : 틀림.
 */
public class Boj3085_3 {

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

        // 사탕을 교환하지 않은 채 최대 갯수가 나오는 경우 탐색
        maxCount = countCantyWithoutSwiching();
        System.out.println("사탕을 교환하지 않은 채 검사시 최대 갯수 > " + maxCount);

        // 0,0 부터 인접한 칸과 교환해보자
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                tmpMax = switchEachNode(x, y);
                maxCount = maxCount > tmpMax ? maxCount : tmpMax;
                System.out.println("tmpMax => " + tmpMax + "["+x+"]["+y+"]");
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

                // 세로로 교환시 2개의 행 체크 (nodeArr[2]이상은 y축(세로)체크)
                if (i > 1) {
                    targetLine[0] = x;
                    targetLine[1] = nextX;
                    maxOneLine = countCandy(targetLine, false, y);
                } else { // 가로로 교환시 2개의 열 체크
                    targetLine[0] = y;
                    targetLine[1] = nextY;
                    maxOneLine = countCandy(targetLine, true, x);
                }

                tmpMax = tmpMax > maxOneLine ? tmpMax : maxOneLine;
                // 끝나고 되돌려야함.
                tmp = candyBox[nextX][nextY];
                candyBox[nextX][nextY] = candyBox[x][y];
                candyBox[x][y] = tmp;
            }
        }

        return tmpMax;

    }
    // end of switchEachNode

    static int countCandy(int[] targetLine, boolean isCul, int myPosition) {

        char startChar = ' ';
        int maxChar = 1;
        int tmpChar = 1;

        //isCul true - 열체크필요 / false - 행체크필요
        if (isCul) { // 열체크
            for (int k = 0; k < targetLine.length; k++) {
                startChar = candyBox[0][targetLine[k]];
                for (int i = 1; i < N; i++) {
                    if (startChar != candyBox[i][targetLine[k]]) {
                        startChar = candyBox[i][targetLine[k]];
                        maxChar = maxChar > tmpChar ? maxChar : tmpChar;
                        tmpChar = 1;
                    } else {
                        tmpChar++;
                    }
                }
            }
        } else { // 행체크
            for (int k = 0; k < targetLine.length; k++) {
                startChar = candyBox[targetLine[k]][0];
                for (int i = 1; i < N; i++) {
                    if (startChar != candyBox[targetLine[k]][i]) {
                        startChar = candyBox[targetLine[k]][i];
                        maxChar = maxChar > tmpChar ? maxChar : tmpChar;
                        tmpChar = 1;
                    } else {
                        tmpChar++;
                    }
                }
            }
        }

        char firstChar = isCul ? candyBox[myPosition][0] : candyBox[0][myPosition];
        int mylineCount = 0;

        for(int i = 1; i< N; i++) {
            // 열체크를 해야하면 myposition 행체크를 해야한다.
            if(isCul) {
                if(firstChar == candyBox[myPosition][i]) {
                    mylineCount++;
                } else {
                    firstChar = candyBox[myPosition][i];
                    mylineCount = 1;
                }
            } else { // 행체크를 해야하면 myposition 열체크를 해야한다.
                if(firstChar == candyBox[i][myPosition]) {
                    mylineCount++;
                } else {
                    firstChar = candyBox[i][myPosition];
                    mylineCount = 1;
                }
            }
        }


        maxChar = maxChar > mylineCount ? maxChar : mylineCount;

        return maxChar;
    }
    // end of checkAmount


    static int countCantyWithoutSwiching() {

        int countRow;
        int countCul;
        int maxCount = 0;

        for (int i = 0; i < N - 1; i++) {
            countRow = 0;
            countCul = 0;
            for (int j = 0; j < N - 1; j++) {
                // 가로(행)이 같은 경우
                if (candyBox[i][j] == candyBox[i][j + 1]) {
                    countRow++;
                    if(j==N-2) {
                        countRow++;
                    }
                }
                // 세로(열)이 같은 경우
                if (candyBox[j][i] == candyBox[j + 1][i]) {
                    countCul++;
                    if(j==N-2) {
                        countCul++;
                    }
                }
            }
            int tmpCount = Math.max(countRow, countCul);
            maxCount = maxCount < tmpCount ? tmpCount : maxCount;
        }

        return maxCount;
    }

}


