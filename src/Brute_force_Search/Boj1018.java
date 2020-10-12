package Brute_force_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Date : 20. 09. 16
 * Question.No : 백준 1018 - 체스판 다시 칠하기
 * Remark :
 */
public class Boj1018 {

    private static char[][] INPUT_BOARD = null;
    private static int N, M;
    private static boolean colorChangeFlag = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        INPUT_BOARD = new char[N][M];
        int minCount = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            String oneLine = br.readLine();
            for (int j = 0; j < M; j++) {
                INPUT_BOARD[i][j] = oneLine.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            if (i <= N - 8) {
                for (int j = 0; j < M; j++) {
                    if (j <= M - 8) {
                        int tmpCount = countSwiching(i, j);
                        minCount = tmpCount < minCount ? tmpCount : minCount;
                        // System.out.println("["+i+"]["+j+"] 를 기준으로 잘랐을때 : "+tmpCount);
                    } else {
                        break;
                    }
                }
            } else {
                break;
            }
        }
        System.out.println(minCount);

        // [0,0]의 색에 따라
        // 짝수줄은 [0,0] [0,2] [0,4] ...
        // [짝,짝]
        // 홀수줄은 [1,1] [1,3] [1,5] ...
        // [홀,홀]
        // 이 모두 [0,0]의 색깔이고
        // 그 외는 모두 [0,0]의 색깔과 다르다.
    }

    public static int countSwiching(int start_x, int start_y) {

        // 색이 같아야 하는 노드 [i+2x][i],
        int count = 0;
        char startColor = ' ';
        int anotherCase = 0;

        if(colorChangeFlag) {
            startColor = getAnotherColor(INPUT_BOARD[start_x][start_y]);
            count++;
        } else {
            startColor = INPUT_BOARD[start_x][start_y];
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if((i%2==0 && j%2==0) || (i%2!=0 && j%2!=0)) {
                    // startColor와 색이 같아야 하는 경우인데 다르면 카운트
                    if(!(i==0 && j==0) && INPUT_BOARD[start_x+i][start_y+j] != startColor) {
                        count++;
                    }
                } else{
                    // startColor와 색이 달라야 하는 경우인데 같으면 카운트
                    if(INPUT_BOARD[start_x+i][start_y+j] == startColor) {
                        count++;
                    }
                }
            }
        }

        if(!colorChangeFlag) {
            colorChangeFlag = true;
            anotherCase = countSwiching(start_x,start_y);
            colorChangeFlag = true;
        } else {
            colorChangeFlag = false;
        }

        if(colorChangeFlag && count>anotherCase) {
            count = (colorChangeFlag && count>anotherCase) ? anotherCase : count;
            colorChangeFlag = false;
        }

        return count;
    }

    public static char getAnotherColor(char color) {
        char result = 'W';
        if(color == result) {
            result = 'B';
        }
        return result;
    }


}
