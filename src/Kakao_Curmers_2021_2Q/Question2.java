package Kakao_Curmers_2021_2Q;/*
 * Date : 2021-04-03
 * Question.No :
 * Remark :
 */

import javax.swing.*;

public class Question2 {

    private static int[] robotCombi;
    private static int compCount;

    public static void main(String[] args) {

        int[][] needs = {{1,1,1,1},{2,2,2,2,},{3,3,3,3}};
        int r = 3;

        solution(needs,r);

    }

    public static int solution(int[][] needs, int r) {

        // 부품의 갯수
        compCount = needs[1].length;
        robotCombi = new int[r];


        // 로봇 조합 구하기
        for (int i = 0; i < compCount; i++) {
            robotCombi[0] = i;
            getRobots(i, 1);
        }


        int answer = 0;
        return answer;
    }

    // 로봇 조합을 배열로
    public static void getRobots(int idx, int depth) {
        if(depth == robotCombi.length) {

            for(int n : robotCombi) {
                System.out.print(n+",");
            }
            System.out.println();
            return;
        }

        for(int i = idx+1; i < compCount; i++) {
            robotCombi[depth] = i;
            getRobots(i, depth+1);
        }

    }

    // n개의 로봇이 몇개의 완제품을 만들 수 있는지 return. 최종적으로 호출되는 함수
    public int getProducts() {


        return 0;
    }
}
