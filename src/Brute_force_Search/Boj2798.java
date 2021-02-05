package Brute_force_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Date : 21. 02. 05
 * Question.No : 백준 2798 - 블랙잭
 * Remark :
 */
public class Boj2798 {

    private static int[] blackJack = new int[3];
    private static int[] cardPack;
    private static int goal,result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstInput = br.readLine().split(" ");
        int n = Integer.parseInt(firstInput[0]);
        goal = Integer.parseInt(firstInput[1]);
        String[] secondInput = br.readLine().split(" ");

        cardPack = new int[n];

        for(int i = 0; i < secondInput.length; i++) {
            cardPack[i] = Integer.parseInt(secondInput[i]);
        }

        for(int i = 0 ; i < cardPack.length; i++){
            blackJack[0] = cardPack[i];
            chooseCards(i, 1, blackJack[0]);
        }

        System.out.println(result);

    }

    public static void chooseCards(int index, int depth, int sum) {

        if(sum > goal) {return;}

        if(depth == 3)  {
            result = goal-sum < goal-result ? sum : result;
            return;
        }

        for(int i=index+1; i<cardPack.length; i++) {
            blackJack[depth] = cardPack[i];
            chooseCards(i+1, depth+1, sum+blackJack[depth]);
            blackJack[depth] = 0;
        }
    }

}
