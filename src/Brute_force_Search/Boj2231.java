package Brute_force_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* Date : 20. 08. 26
* Question.No : 백준 2231 - 분해합
* Remark : 시간이 다른사람들 풀이보다 오래걸림. 메모리는 not bad. 체크해볼것
*/
public class Boj2231 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int answer = 0;
        int tmp = 0;

        if(input!=1){
            for (int i = 1; i < input; i++) {
                tmp = getSumValue(i);
                if(input == tmp){
                    answer = i;
                    break;
                };
            }
        }

        System.out.println(answer);
    }

    static int getSumValue(int org) {
        int targetNum = org;
        int sum = org;
        // 순수 자릿수를 구하고 싶다면 상용로그값 + 1 하면 됨.
        int startNum = (int)Math.pow(10,Math.floor(Math.log10(org)));
        while(targetNum!=0) {
            sum += targetNum/startNum;
            targetNum = targetNum%startNum;
            startNum /= 10;
        }
        return sum;
    }

}
