package org.example.백준.알고리즘기초_1_강의.자료구조1.큐_10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        int input = 0;

        int a = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < a ; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String cmd = st.nextToken();

            switch(cmd) {
                case "push":

                    input = Integer.parseInt(st.nextToken());

                    queue.offer(input);

                    break;

                case "pop":
                    if(!queue.isEmpty()) {
                        sb.append(queue.poll()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }

                    break;

                case "size":
                    sb.append(queue.size()).append("\n");
                    break;

                case "empty":
                    if(queue.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;

                case "front":
                    if(!queue.isEmpty()) {
                        sb.append(queue.peek()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;

                case "back":
                    if(!queue.isEmpty()) {
                        sb.append(input).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;
            }

        }
        System.out.println(sb);

    }
}
