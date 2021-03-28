package String_ex;

/*
 * Date : 2021-03-28
 * Question.No :
 * Remark :
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Boj1181 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        List<String> words = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            words.add(br.readLine());
        }

        // answer1 )
        Comparator<String> compare = (s1, s2) -> s1.length() == s2.length() ? s1.compareTo(s2) : s1.length() - s2.length();
        words.stream().distinct().sorted(compare).forEach(System.out::println);

        // answer2 ) 얘는 sort 두번함 -> 느림
/*        words.stream()
                .distinct()
                .sorted(Comparator.comparing(String::length).thenComparing(String::compareTo))
                .forEach(System.out::println);*/

        // * length 비교 : Integer.comp
/*         Comparator<String> compare2 = (s1, s2) -> {
            int x = Integer.compare(s1.length(),s2.length());
            return x==0 ? s1.compareTo(s2):x;
        };*/
    }
}
