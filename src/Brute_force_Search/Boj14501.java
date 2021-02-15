package Brute_force_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



/*
 * Date : 21. 02. 09
 * Question.No : 백준 14501 - 퇴사
 * URL : https://www.acmicpc.net/problem/14501
 * Remark : 수정했으나 어떻게 푼 지 모르겠음. 도움이 됐던 글
 * //https://www.acmicpc.net/board/view/62119
 */
public class Boj14501 {

    private static int[][] schedule;

    public static void main(String[] args) {

        int maxPay = 0;

        try {
            setScheduleByInput();
        } catch(IOException e) {
            System.out.println("[ERROR] : " + e.getMessage());
        }

        maxPay = getMaxPay(0,0);
        System.out.println(maxPay);

    }


    public static void setScheduleByInput() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        schedule = new int[2][N];

        for(int i = 0 ; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            schedule[0][i] = Integer.parseInt(st.nextToken());
            schedule[1][i] = Integer.parseInt(st.nextToken());
        }
    }

    public static int getMaxPay(int currMax, int start) {

        int nextDay = 0;
        int maxPay = currMax;
        int tmp = 0;

        for(int i = start ; i < schedule[0].length; i+=nextDay) {
            if(i+schedule[0][i] <= schedule[0].length) {
                // 나를 선택하지 않는 경우
                tmp = Math.max(tmp,getMaxPay(maxPay,i+1));
                // 나를 선택하는 경우
                maxPay += schedule[1][i];
                nextDay = schedule[0][i];
            } else {
                nextDay=1;
            }
        }

        return Math.max(tmp,maxPay);
    }

}
