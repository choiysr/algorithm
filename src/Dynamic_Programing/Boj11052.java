package Dynamic_Programing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * Date : 20. 10. 22
 * Question.No : 백준 11052 - 카드 구매하기
 * Remark :
 */
public class Boj11052 {

    private static int N = 0;
    private static int[] cardPacks = null;
    private static boolean[] checkNumber = null;
    private static int maxAmount = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cardPacks = new int[N + 1];
        String[] input = br.readLine().split(" ");
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(N);

        for (int i = 1; i <= N; i++) {
            cardPacks[i] = Integer.parseInt(input[i - 1]);
        }

        while (true) {
            calHowMushPay(stack.toArray());
            int tmp = stack.pop();
            if (tmp != 1) {
                stack.push(tmp - 1);
                stack.push(1);
            } else {
                int sum = 2;
                for (; !stack.isEmpty() && stack.peek() == 1; stack.pop()) sum++;
                if (stack.isEmpty()) break;
                int pivot = stack.pop() - 1;
                stack.push(pivot);
                while (sum > pivot) {
                    stack.push(pivot);
                    sum -= pivot;
                }
                stack.push(sum);
            }
        }

        System.out.println(maxAmount);


    }

    private static void calHowMushPay(Object[] arr) {

        int sum = 0;

        for(int i = 0; i <arr.length; i++) {
            int n = (int)arr[i];
            sum += cardPacks[n];
        }

        maxAmount = Math.max(maxAmount,sum);

    }
}
