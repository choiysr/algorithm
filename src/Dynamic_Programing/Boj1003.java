package Dynamic_Programing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * Date : 21. 02. 23
 * Question.No : 백준 1003 - 피보나치 함수
 * Remark :
 */
public class Boj1003 {

    private static int[][] arr;
    private static List<Integer> cases = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int maxCase = 0;

        for(int i = 0 ; i < testCase ; i++) {
            int tc = Integer.parseInt(br.readLine());
            cases.add(tc);
            maxCase = maxCase < tc ? tc : maxCase;
        }
        setArr(maxCase);

        for(int i = 0 ; i < cases.size(); i++) {
            print(cases.get(i));
        }

    }

    public static void setArr(int maxCase) {
        arr = new int[2][maxCase+1];
        arr[0][0] = 1;
        arr[1][0] = 0;
        arr[0][1] = 0;
        arr[1][1] = 1;
        for(int i = 2 ; i <= maxCase; i++) {
            arr[0][i] = arr[0][i-1] + arr[0][i-2];
            arr[1][i] = arr[1][i-1] + arr[1][i-2];
        }
    }

    public static void print(int idx) {
        System.out.println(arr[0][idx]+" "+arr[1][idx]);
    }



}

