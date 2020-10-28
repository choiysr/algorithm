package Dynamic_Programing;

import java.util.Scanner;

/*
 * Date : 20. 10. 26
 * Question.No : 백준 1463 - 1로 만들기
 * Remark :
 */
public class Boj1463 {

    private static int minCount = Integer.MAX_VALUE;

    public static void main(String[] args) {

        // X가 3으로 나누어 떨어지면, 3으로 나눈다.
        // X가 2로 나누어 떨어지면, 2로 나눈다.
        // 1을 뺀다.

        // 3으로 나누어 떨어지는 경우
        // 2로 나누어 떨어지는 경우
        // 1을 뺀 경우를 기억한다.

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        calEachWay(n,0);

        System.out.println(minCount);

    }

    private static void calEachWay(int n, int count) {

        if(n==1) {
            minCount = Math.min(count, minCount);
            return;
        }

        if(n%3==0) {
            calEachWay(n/3, ++count);
            --count;
        }

        if(n%2==0) {
            calEachWay(n/2, ++count);
            --count;
        }

        calEachWay(n-1,++count);
        --count;

    }


}
