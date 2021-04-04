package String_ex;/*
 * Date : 2021-04-04
 * Question.No :
 * Remark :
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Boj1764 {

    public static void main(String[] args) throws IOException {

        // list.retainAll 이후 collection.sort  >> 시간초과
        // 입력받을때 먼저 리스트에 있는지 검사하고 각각 다른곳에 삽입하여 collection.sort >> 시간초과
        // 입력받을때 먼저 리스트에 있는지 검사 없으면 set에 삽입 >> 시간초과
        // 둘다 set 사용

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> people = new TreeSet<>();
        Set<String> retainSet = new TreeSet<>();


        for(int i = 0 ; i < N+M; i++) {
            String name = br.readLine();
            if(people.contains(name)) {
                retainSet.add(name);
            } else {
                people.add(name);
            }
        }

        System.out.println(retainSet.size());
        Iterator<String> iter = retainSet.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }



    }
}
