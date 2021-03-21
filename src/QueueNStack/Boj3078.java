package QueueNStack;/*
 * Date : 2021-03-21
 * Question.No :
 * Remark : 다른사람 코드 풀이.
 */

import java.io.*;
import java.util.*;

public class Boj3078 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numberOfStudent = Integer.parseInt(st.nextToken());
        int gapOfPoint = Integer.parseInt(st.nextToken());
        long freindsCount = 0;

        Queue<Integer>[] nameLenArr = new Queue[21];

        for (int i = 0; i <= 20; i++) {
            nameLenArr[i] = new LinkedList<>();
        }

        // 배열의 인덱스는 이름의 길이이고, 각 인덱스에 들어가는 Queue객체에는 그 길이에 해당하는 사람의 등수가 들어간다.
        for (int nowIndex = 0; nowIndex < numberOfStudent; nowIndex++) {
            int nameLen = br.readLine().length();

            // Queue가 비어있으면 현재 원소를 길이에 맞는 위치의 Queue에 넣어준다.
            if (nameLenArr[nameLen].isEmpty()) {
                nameLenArr[nameLen].offer(nowIndex);
                continue;
            }

            // gapOfPoint : 등수차이
            // 현재 원소의 등수와 Queue에 가장 먼저 들어간 원소의 등수를 빼서
            // 주어진 등수차(K)보다 클 경우에는(좋은 친구가 아닌 경우) Queue에서 꺼낸다.(이후 계산에서 제외되도록)
            while (nowIndex - nameLenArr[nameLen].peek() > gapOfPoint) {
                nameLenArr[nameLen].poll();
                if (nameLenArr[nameLen].isEmpty()) {
                    break;
                }
            }

            // 현재 원소(이름 길이)에 맞는 위치의 Queue 사이즈를 Count 한다.
            // 사이즈만큼 카운트를 해주는 이유 ▽
            // ex1. 주어진 등수차(K)가 3인 경우.
            // 큐 안에 들어가 있는 원소가 0(등)이 있고 지금 1(등)가 들어가야 하는경우에
            // 1를 넣기 전에 큐 사이즈(1) 을 넣는다. ->0등과 1등 한 쌍
            // 그 다음 원소가 2이라면 큐 사이즈(2)를 추가로 넣는다. -> 0과2, 1와2 총 두 쌍.
            // 그 다음 원소가 3이라면 큐 사이즈(3)을 추가로 넣는다. -> 0과3, 1과3, 2와3 총 세 쌍.
            // 그 다음 원소가 4라면 큐 사이즈(3 - 앞의 과정(while문)에서 가장 먼저 들어간 0등이 제외됐을 것이므로)을 추가로 넣는다
            // -> 1과4, 2와4, 3과4, 총 세 쌍.
            freindsCount += nameLenArr[nameLen].size();  // 큐 사이즈를 먼저 count에 합한다.-들어갈 원소와 기존 원소와의 쌍을 계산.
            nameLenArr[nameLen].offer(nowIndex); // 현재 원소를 추가.
        }

        System.out.println(freindsCount);

        br.close();
    }
}