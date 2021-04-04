package Kakao_Curmers_2021_2Q;/*
 * Date : 2021-04-03
 * Question.No :
 * Remark :
 */


// gift_cards
// want

// 4 5 3 2 1
// 2 4 4 5 1

// 5 4 5 4 5
// 1 2 3 5 4

public class Question1 {

    public static void main(String[] args) {
//        int[] gifts = {5,4,5,4,5};
//        int[] wants = {1,2,3,5,4};

        int[] gifts = {4,5,3,2,1};
        int[] wants = {2,4,4,5,1};
        System.out.println(solution(gifts,wants));
    }

    public static int solution(int[] gift_cards, int[] wants) {

        int[] pack = new int[100000];
        int answer = wants.length;

        for(int gift : gift_cards) {
            pack[gift]++;
        }

        for(int each : wants) {
            if(pack[each]>0) {
                pack[each]--;
                answer--;
            }
        }

        return answer;
    }
}
