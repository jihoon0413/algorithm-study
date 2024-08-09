package org.example.백준.알고리즘기초_1.자료구조1.요세푸스문제_1158;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        sb.append("<");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < a ; i++) {
            queue.offer(i+1);
        }

        while (queue.size() != 1) {

            for(int i = 0 ; i < b-1 ; i++) {
                queue.offer(queue.poll());
            }

            sb.append(queue.poll()).append(", ");

        }

        sb.append(queue.poll()).append(">");

        System.out.println(sb);

    }
}
