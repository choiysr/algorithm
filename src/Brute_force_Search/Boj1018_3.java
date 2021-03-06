package Brute_force_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Date : 21. 02. 09
 * Question.No : 백준 1018 - 체스판 다시 칠하기
 * Remark :
 */
public class Boj1018_3 {

    private static char[][] board;
    private static int N, M;
    private static final int SIZE = 8;

    public static void main(String[] args) {

        // 하나만 구해서 64에서 뺀 후 둘 중 작은 수가 min
        int minValue = SIZE*SIZE;

        try {
            setOrgBoardByInput();
        } catch (IOException e) {
            System.out.println("[ERROR]");
        }

        for (int i = 0; i < N; i++) {
            if (i <= N - SIZE) {
                for (int j = 0; j < M; j++) {
                    if(j <= M - SIZE) {
                        minValue = Math.min(minValue,getHowManyNodesMustChange(i, j));
                    }
                }
            }
        }

        System.out.println(minValue);


    }

    public static void setOrgBoardByInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputLine = br.readLine().split(" ");
        N = Integer.parseInt(inputLine[0]);
        M = Integer.parseInt(inputLine[1]);
        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String eachLine = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = eachLine.charAt(j);
            }
        }
    }

    public static int getHowManyNodesMustChange(int startX, int startY) {

        int count = 0;
        // 합이 짝수면 B, 홀수면 W
        for (int i = startX; i < startX+SIZE; i++) {
            for (int j = startY; j < startY+SIZE; j++) {
                // 합이 짝수인데 board에서 B가 아니거나, 합이 홀수인데 board에서 W가 아닐 때 count++
                if (((0 == ((i + j) % 2)) && (board[i][j] != 'B')) || ((0 != ((i + j) % 2)) && (board[i][j] == 'B'))) {
                    count++;
                }
            }
        }

        return Math.min((SIZE*SIZE) - count, count);

    }

}
