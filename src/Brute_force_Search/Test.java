package Brute_force_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Test {

    private static int maxNum = 0; // 주어진 범위 내 최대 n
    
    public static void main(String[] args) throws IOException {
        int[] triNum = getTriNum();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] inputList = new int[num];
        
        for (int i = 0; i < num; i++) {
            inputList[i] = Integer.parseInt(br.readLine());
        }
        
        for (int i = 0; i < num; i++){
            for (int j = 0; j < maxNum; j++) {
                if (inputList[i] == triNum[j]){
                    System.out.println("1");
                    break;
                }
                if (j == maxNum)
                    System.out.println("0");
            }
            
        }
    }

    // maxNum 크기의 삼각수 리스트 
    private static int[] getTriNum(){
        int[] numList = null;
        int n = 1;
        while (n*(n+1)/2 < 1000) {
            n ++;
        }
        maxNum = n -1;
        numList = new int[maxNum];
        
        for (int i = 0; i < maxNum; i ++){
            numList[i] = i*(i+1) / 2;
        }
        return numList;
    }
}
