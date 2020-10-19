package Brute_force_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Date : 20. 10. 04
 * Question.No : 백준 3085 - 사탕 게임
 * URL : https://www.acmicpc.net/problem/3085
 * Remark :
 */
public class Boj3085_5 {

    private static int N = 0;
    private static char[][] candyBox = null;
    private static int[] direction = {0,1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int candyMax = 1;
        int tmpMax = 1;

        N = Integer.parseInt(br.readLine());
        candyBox = new char[N][N];


        for (int i = 0; i < N; i++) {
            String eachLine = br.readLine();
            for (int j = 0; j < N; j++) {
                candyBox[i][j] = eachLine.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tmpMax = switchEachOther(i, j);
                candyMax = candyMax > tmpMax ? candyMax : tmpMax;
            }
        }

        System.out.println(candyMax);

    }

    public static int switchEachOther(int x, int y) {

        int nextX = 0;
        int nextY = 0;
        char tmp = ' ';
        int candyMax = 1;
        int tmpMax = 1;

        for (int i = 0; i < 2; i++) {
            if (!(x + direction[i] >= candyBox.length || y + (1-direction[i]) >= candyBox.length)) {
                nextX = x + direction[i];
                nextY = y + (1-direction[i]);
                tmp = candyBox[x][y];
                candyBox[x][y] = candyBox[nextX][nextY];
                candyBox[nextX][nextY] = tmp;
                // i가 0일때는 0,1 이동 => 자기 라인 가로줄과 세로줄 2개 체크 필요
                // i가 1일때는 1,0 이동 => 자기 라인 세로줄과 가로줄 2개 체크 필요
                if (i == 0) {
                    tmpMax = checkLineOfBox(true, x, y, nextY);
                } else {
                    tmpMax = checkLineOfBox(false, y, x, nextX);
                }

                // 원복
                candyBox[nextX][nextY] = candyBox[x][y];
                candyBox[x][y] = tmp;

                candyMax = candyMax > tmpMax ? candyMax : tmpMax;

            }
        }

        return candyMax;
    }

    public static int checkLineOfBox(boolean isRow, int myLine, int line1, int line2) {

        int countMyLine = 1;
        int countLine1 = 1;
        int countLine2 = 1;

        int tmpCountMyLine = 1;
        int tmpCountLine1 = 1;
        int tmpCountLine2 = 1;

        int candyMax = 0;
        Node ownLineNode = new Node();
        Node line1Node = new Node();
        Node line2Node = new Node();

        for(int i = 0 ; i < N-1; i++) {

            // isRow == true
            // candyBox[myLine][i]
            // candyBox[i][line1]
            // candyBox[i][line2]

            // isRow == false
            // candyBox[i][myLine]
            // candyBox[line1][i]
            // candyBox[line2][i]
            if(isRow) {
                ownLineNode.setNode(myLine,i);
                line1Node.setNode(i,line1);
                line2Node.setNode(i,line2);
            } else {
                ownLineNode.setNode(i,myLine);
                line1Node.setNode(line1,i);
                line2Node.setNode(line2,i);
            }



        }

        if (isRow) {
            for (int i = 0; i < N - 1; i++) {
                // 자기라인
                // candyBox[myLine][i];
                if (candyBox[myLine][i] == candyBox[myLine][i + 1]) {
                    tmpCountMyLine++;
                } else {
                    countMyLine = tmpCountMyLine > countMyLine ? tmpCountMyLine : countMyLine;
                    tmpCountMyLine = 1;
                }
                // 세로두줄 체크 (line고정)
                // candyBox[i][line1];
                if (candyBox[i][line1] == candyBox[i + 1][line1]) {
                    tmpCountLine1++;
                } else {
                    countLine1 = tmpCountLine1 > countLine1 ? tmpCountLine1 : countLine1;
                    tmpCountLine1 = 1;
                }

                // candyBox[i][line2];
                if (candyBox[i][line2] == candyBox[i + 1][line2]) {
                    tmpCountLine2++;
                } else {
                    countLine2 = tmpCountLine2 > countLine2 ? tmpCountLine2 : countLine2;
                    tmpCountLine2 = 1;
                }
            }
        } else {
            for (int i = 0; i < N - 1; i++) {
                // 자기라인
                // candyBox[i][myline];
                if (candyBox[i][myLine] == candyBox[i+1][myLine]) {
                    tmpCountMyLine++;
                } else {
                    countMyLine = tmpCountMyLine > countMyLine ? tmpCountMyLine : countMyLine;
                    tmpCountMyLine = 1;
                }
                // 세로두줄 체크 (line고정)
                // candyBox[i][line1];
                if (candyBox[line1][i] == candyBox[line1][i+1]) {
                    tmpCountLine1++;
                } else {
                    countLine1 = tmpCountLine1 > countLine1 ? tmpCountLine1 : countLine1;
                    tmpCountLine1 = 1;
                }

                // candyBox[i][line2];
                if (candyBox[line2][i] == candyBox[line2][i+1]) {
                    tmpCountLine2++;
                } else {
                    countLine2 = tmpCountLine2 > countLine2 ? tmpCountLine2 : countLine2;
                    tmpCountLine2 = 1;
                }
            }
        }

        countMyLine = tmpCountMyLine > countMyLine ? tmpCountMyLine : countMyLine;
        countLine1 = tmpCountLine1 > countLine1 ? tmpCountLine1 : countLine1;
        countLine2 = tmpCountLine2 > countLine2 ? tmpCountLine2 : countLine2;

        // System.out.println("MYLINE : "+countMyLine + "/ LINE1 : "+countLine1+ "/ LINE2 : "+countLine2);

        candyMax = Math.max(countMyLine, Math.max(countLine1, countLine2));

        return candyMax;

    } // end of checkLineOfBox


    private static class Node {
        int x = 0;
        int y = 0;

        void setNode(int x, int y) {
            this.x = x;
            this.y = y ;
        }
    }


} // end of Main Class
