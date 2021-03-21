package Dynamic_Programing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

/*
 * Date : 21. 03. 13
 * Question.No : 백준 2839 - 설탕배달
 * Remark : DP 이용
 */
public class Boj2839_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sugar = Integer.parseInt(br.readLine());

        if (sugar == 4 || sugar == 7) {
            System.out.println(-1);
            return;
        }

        int[] arr = new int[5001];
        Arrays.fill(arr, Integer.MAX_VALUE - 1);
        arr[3] = 1;
        arr[5] = 1;


        for (int i = 6; i <= sugar; i++) {
            arr[i] = Math.min(arr[i - 3], arr[i - 5]) + 1;
        }

        System.out.println(arr[sugar]);

    }


}
