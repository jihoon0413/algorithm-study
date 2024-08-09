package org.example.백준.알고리즘기초_1.자료구조1.덱_10866;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> deque = new LinkedList<>();

        int a = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < a ; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String cmd = st.nextToken();

            switch (cmd) {

                case "push_front":
                    deque.offerFirst(Integer.parseInt(st.nextToken()));
                    break;

                case "push_back":
                    deque.offer(Integer.parseInt(st.nextToken()));
                    break;

                case "pop_front":
                    if(!deque.isEmpty()) {
                        bw.write(deque.pollFirst() + "\n");
                    } else {
                        bw.write(-1 + "\n");
                    }
                    break;

                case "pop_back":
                    if(!deque.isEmpty()) {
                        bw.write(deque.pollLast() + "\n");
                    } else {
                        bw.write(-1 + "\n");
                    }
                    break;

                case "size":
                    bw.write(deque.size()+ "\n");
                    break;

                case "empty":
                    if(deque.isEmpty()) {
                        bw.write(1 + "\n");
                    } else {
                        bw.write(0 + "\n");
                    }
                    break;

                case "front":
                    if(!deque.isEmpty()) {
                        bw.write(deque.getFirst() + "\n");
                    } else {
                        bw.write(-1 + "\n");
                    }
                    break;

                case "back":
                    if(!deque.isEmpty()) {
                        bw.write(deque.getLast() + "\n");
                    } else {
                        bw.write(-1 + "\n");
                    }
                    break;
            }
        }

        bw.flush();
        bw.close();

    }
}
