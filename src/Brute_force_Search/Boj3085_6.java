package Brute_force_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Date : 21. 02. 08
 * Question.No : 백준 3085 - 사탕 게임
 * URL : https://www.acmicpc.net/problem/3085
 * Remark :
 */
public class Boj3085_6 {

    private static char[][] candyBox;
    private static int boxSize;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boxSize = Integer.parseInt(br.readLine());
        candyBox = new char[boxSize][boxSize];
        int edibleCandies = 0;

        for(int i = 0 ; i < boxSize ; i++) {
            String eachLine = br.readLine();
            for(int j = 0; j < boxSize ; j++) {
                candyBox[i][j] = eachLine.charAt(j);
            }
        }

        for(int i = 0 ; i < boxSize ; i++) {
            for(int j = 0 ; j < boxSize; j++) {
                // 맨 오른쪽 끝줄이 아닌경우 > 우측과 교환
                if(j!=boxSize-1) {
                    switchEachCandy(false, i, j,j+1);
                    // 해당 라인과 두개의 열 체크
                    edibleCandies = Math.max(edibleCandies,Math.max(getMaxCandiesInRow(i),Math.max(getMaxCandiesInCul(j),getMaxCandiesInCul(j+1))));
                    // 원복
                    switchEachCandy(false, i,j+1,j);
                }

                // 맨 아래 끝줄이 아닌경우 > 아래측과 교환
                if(i!=boxSize-1) {
                    switchEachCandy(true, j,i,i+1);
                    // 해당 라인과 두개의 행 체크
                    edibleCandies = Math.max(edibleCandies,Math.max(getMaxCandiesInCul(j),Math.max(getMaxCandiesInRow(i),getMaxCandiesInRow(i+1))));
                    // 원복
                    switchEachCandy(true, j,i+1,i);
                }
            }
        }

        System.out.println(edibleCandies);

    } // end of main

    // @isRow : true - 상하교환 / false - 좌우교환
    // @keepingLine : 고정시켜야 하는 위치(x or y), isRow가 true일 경우 열번호, flase일 경우 행번호
    public static void switchEachCandy(boolean isRow, int fixedPosition, int firstPosition, int secondPosition) {

        if(isRow) {
            char tmp = candyBox[firstPosition][fixedPosition];
            candyBox[firstPosition][fixedPosition] = candyBox[secondPosition][fixedPosition];
            candyBox[secondPosition][fixedPosition] = tmp;
        } else {
            char tmp = candyBox[fixedPosition][firstPosition];
            candyBox[fixedPosition][firstPosition] = candyBox[fixedPosition][secondPosition];
            candyBox[fixedPosition][secondPosition] = tmp;
        }

    }

    // 세로 체크 (열체크)
    public static int getMaxCandiesInCul(int culNum) {

        int max = 1;
        int count = 1;
        char targetCandy = candyBox[0][culNum];

        for(int i = 1 ; i < boxSize; i++) {
            if(targetCandy == candyBox[i][culNum]) {
                count++;
                max = Math.max(max, count);
            } else {
                targetCandy = candyBox[i][culNum];
                max = Math.max(max, count);
                count = 1;
            }
        }

        return max;
    }

    // 가로 체크 (행체크)
    public static int getMaxCandiesInRow(int rowNum) {

        int max = 1;
        int count = 1;
        char targetCandy = candyBox[rowNum][0];

        for(int i = 1 ; i < boxSize; i++) {
            if(targetCandy == candyBox[rowNum][i]) {
                count++;
                max = Math.max(max, count);
            } else {
                targetCandy = candyBox[rowNum][i];
                max = Math.max(max, count);
                count = 1;
            }
        }

        return max;
    }


}
