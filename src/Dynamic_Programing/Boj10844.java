package Dynamic_Programing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * Date : 20. 10. 28
 * Question.No : 백준 10844 - 쉬운 계단 수
 * Remark :
 */
public class Boj10844 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10]; // 0~9
        boolean[] check = new boolean[10];
        Arrays.fill(check,false);
        Arrays.fill(arr, 1);
        arr[0] = 0;
        int count = 9;


        // i 이전 남아있는 수의 갯수가 n을 초과하면 다름
        // i 이후 남아있는 수의 갯수가 n을 초과하면 달라짐

        // 영향 없는 애들은 그동안꺼 더한거
        // 영향권에 있는 애들은 그동안꺼 더한거 -1

        for (int i = 2; i <= n; i++) {
            count = 0;
            for (int j = 0; j < 10; j++) {
                if (j == 0) continue;
                if(check[j]) {
                    arr[j] = arr[j]+1;
                }
                else if ((j - i < -1 || j + i > 10) && !check[j]) {
                    arr[j] = arr[j]*2 - 1;
                    check[j] = true;
                } else {
                    arr[j] = arr[j]*2;
                }

                if(i==n) {
                    count += arr[j];
                }
            }
        }

        for(int i = 0 ; i <10; i++) {
            System.out.print(arr[i]+",");
        }

        System.out.println(count);





    }
}
