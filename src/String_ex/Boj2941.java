package String_ex;

/*
 * Date : 2021-03-28
 * Question.No : 2941 - 크로아티아 알파벳
 * Remark : Stream 써서 해보자 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2941 {

    public static void main(String[] args) throws IOException {

        List<String> dictionary = new ArrayList<>(Arrays.asList("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="));
        dictionary.sort((s1,s2)-> s2.length()-s1.length());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer input = new StringBuffer(br.readLine());
        int count = 0;

        for (String word : dictionary) {
            while (input.lastIndexOf(word) != -1) {
                int lastIndex = input.lastIndexOf(word);
                input.replace(lastIndex, lastIndex + word.length(), "0");
                count++;
            }
        }

        System.out.println(input.toString().replaceAll("0","").length()+count);

    }
}
