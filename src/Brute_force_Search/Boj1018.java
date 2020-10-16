package Brute_force_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Date : 20. 10. 16
 * Question.No : 백준 1018 - 체스판 다시 칠하기
 * Remark : switchEachColor()에서 중간에 끊어주는 로직(최종 result보다 클경우) 없이 모두 수행. 이후 count와 64-count를 비교하여 작은값을 리턴.
 *          1018_2에 비해 시간이 아주조금 더 걸림.(92)
 */
public class Boj1018 {

    private static char[][] inputBoard = null;
    private static int result = 64;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // [0] - 세로 / [1] - 가로
        String[] size = br.readLine().split(" ");
        inputBoard = new char[Integer.parseInt(size[0])][Integer.parseInt(size[1])];

        for (int i = 0; i < inputBoard.length; i++) {
            String eachLine = br.readLine();
            for (int j = 0; j < inputBoard[i].length; j++) {
                inputBoard[i][j] = eachLine.charAt(j);
            }
        }

        for (int i = 0; i < inputBoard.length; i++) {
            if (!(inputBoard.length - i < 8)) {
                for (int j = 0; j < inputBoard[i].length; j++) {
                    if (!(inputBoard[i].length - j < 8)) {
                        int tmpMin = switchEachColor(i, j);
                        result = tmpMin < result ? tmpMin : result;
                    }
                }
            }
        }
        System.out.println(result);
    }

    public static int switchEachColor(int x, int y) {
        char firstChar = inputBoard[x][y];
        int count = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if((i + j) % 2 == 0) {
                    // 색깔이 같아야 하는 경우
                    if(inputBoard[i + x][j + y] != firstChar) {
                        count++;
                    }
                } else {
                    // 색깔이 달라야 하는 경우
                    if(inputBoard[i + x][j + y] == firstChar) {
                        count++;
                    }
                }
            }
        }
        count = Math.min(count, 64-count);
        return count;
    }


}
