package QueueNStack;/*
 * Date : 2021-03-21
 * Question.No :
 * Remark :
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Boj5430 {

    static class MQueue {
        private Queue<Integer> queue;

        public MQueue(List<Integer> original) {
            this.queue = new LinkedList<>(original);
        }

        public void reverse() {
            Stack<Integer> stack = new Stack<>();
            while (!queue.isEmpty()) {
                stack.push(queue.poll());
            }
            while (!stack.isEmpty()) {
                queue.add(stack.pop());
            }
        }

        public boolean delete() {
            if (this.queue.isEmpty()) {
                return false;
            }
            this.queue.poll();
            return true;
        }

        public void print() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            while (!this.queue.isEmpty()) {
                sb.append(this.queue.poll());
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("]");
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            String func = br.readLine();
            int size = Integer.parseInt(br.readLine());
            if (size == 0) {
                if (func.contains("D")) {
                    System.out.println("error");
                } else {
                    System.out.println(br.readLine());
                }
                continue;
            }
            MQueue mq = new MQueue
                    (Stream.of(br.readLine()
                            .substring(1, 2 * size)
                            .split(","))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList()));
            executeFunction(func, mq);
        }


    }

    public static void executeFunction(String funcCodes, MQueue mq) {
        for (int i = 0; i < funcCodes.length(); i++) {
            if (funcCodes.charAt(i) == 'R') {
                mq.reverse();
            } else {
                if (!mq.delete()) {
                    System.out.println("error");
                    return;
                }
                ;
            }
        }
        mq.print();
    }


}
