package Brute_force_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Date : 20. 10. 22
 * Question.No : 백준 1182 - 부분수열의 합
 * Remark : 틀림!!!!!!!!!!!!!!!
 */
public class Boj1182 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        String[] inputArr = br.readLine().split(" ");
        int count = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputArr[i]);
            if(arr[i] == s) {
                count++;
            }
        }

        for (int i = 0; i < n; i++) {
            int sum = arr[i];
            for (int j = i+1; j < n; j++) {
                if((j!=n-1 && sum + arr[j] + arr[j+1] == s) || (j==n-1 && sum+arr[j]==s)) {
                    sum+=arr[j];
                    count++;
                } else {
                    sum += arr[j];
                }
            }
        }

        System.out.println(count);


    }
}
