package Brute_force_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Date : 20. 10. 16
 * Question.No : 백준 1018 - 체스판 다시 칠하기
 * Remark : 맨 첫번째 칸이 B일경우 W일경우를 모두 검사하지만(3중for문으로 구현했으나) 중간에 result보다 큰값이 나올 경우 끊어주는 로직이 있어 앞선 풀이법보다
 *          시간이 적게 소요됨(88). 큰 차이는 없음.
 */
public class Boj1018_2 {

    private static char[][] inputBoard = null;
    private static int result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // [0] - 세로 / [1] - 가로
        String[] size = br.readLine().split(" ");
        result = 64;
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


    // x - 세로위치, y - 가로위치
    public static int switchEachColor(int x, int y) {

        int finalCount = 64;
        char[] blackNWithe = {'B', 'W'};

        for (int k = 0; k < 2; k++) {
            char firstChar = blackNWithe[k];
            int count = 0;
            Loop:
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
/*                    if((i + j) % 2 == 0) {
                        // 색깔이 같아야 하는 경우
                        if(inputBoard[i + x][j + y] != firstChar) {
                            count++;
                        }
                    } else {
                        // 색깔이 달라야 하는 경우
                        if(inputBoard[i + x][j + y] == firstChar) {
                            count++;
                        }
                    }*/
                    count = ((i + j) % 2 == 0) ? ((inputBoard[i + x][j + y] != firstChar) ? count + 1 : count)
                            : ((inputBoard[i + x][j + y] == firstChar) ? count + 1 : count);
                    if (result <= count || finalCount <= count) {
                        break Loop;
                    }
                }
            }
            finalCount = count < finalCount ? count : finalCount;
        }
        return finalCount;
    }
}
