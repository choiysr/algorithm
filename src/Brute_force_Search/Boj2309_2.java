package Brute_force_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj2309_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> babies = new ArrayList<>(10);
        int sum = 0;

        for(int i = 0 ; i < 9; i++) {
            babies.add(Integer.parseInt(br.readLine()));
            sum+=babies.get(i);
        }

        Loop : for(int i = 0 ; i < 8; i++) {
            for(int j = i+1; j < 9; j++) {
                if(100 == sum-babies.get(i)-babies.get(j)) {
                    babies.remove(j);
                    babies.remove(i);
                    break Loop;
                }
            }
        }

        babies.stream().sorted().forEach(System.out::println);

    }
}
