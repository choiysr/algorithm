package Brute_force_Search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Date : 20. 10. 25
 * Question.No : 백준 1182 - 부분수열의 합
 * Remark : 보고 풀었고 이해 못함.
 */
public class Boj1182 {

    private static int count = 0;
    private static int n, s;
    private static int[] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        powerSet(0,0);

        if(s == 0) count--;

        System.out.println(count);

    }

    private static void powerSet(int idx, int sum) {

        System.out.println("idx = "+idx+","+"sum = "+sum);

        if (idx == n) {
            if (sum == s) {
                count++;
            }
            return;
        }

        powerSet(idx+1, sum);
        powerSet(idx+1, sum+arr[idx]);

    }
}
