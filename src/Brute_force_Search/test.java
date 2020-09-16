package Brute_force_Search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while(sc.hasNextInt()) {
            list.add(sc.nextInt());
        }

        sc.close();


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        for(Integer str : list ) {
            System.out.println(str);
        }

    }
}
