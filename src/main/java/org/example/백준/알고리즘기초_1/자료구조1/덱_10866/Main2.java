package org.example.백준.알고리즘기초_1.자료구조1.덱_10866;

import java.io.*;
import java.util.StringTokenizer;

public class Main2 {
    static int front = 10000;
    static int back = 10001;
    static int size = 0;
    static int[] deque = new int[20001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < a ; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String cmd = st.nextToken();

            switch (cmd) {

                case "push_front":

                    deque[front] = Integer.parseInt(st.nextToken());
                    front--;
                    size++;
                    break;

                case "push_back":
                    deque[back] = Integer.parseInt(st.nextToken());
                    back++;
                    size++;
                    break;

                case "pop_front":
                    if(size != 0) {
                        bw.write(deque[front+1] + "\n");
                        front++;
                        size--;
                    } else {
                        bw.write(-1 + "\n");
                    }
                    break;

                case "pop_back":
                    if(size != 0) {
                        bw.write(deque[back-1] + "\n");
                        back--;
                        size--;
                    } else {
                        bw.write(-1 + "\n");
                    }
                    break;

                case "size":
                    bw.write(size+ "\n");
                    break;

                case "empty":
                    if(size == 0) {
                        bw.write(1 + "\n");
                    } else {
                        bw.write(0 + "\n");
                    }
                    break;

                case "front":
                    if(size != 0) {
                        bw.write(deque[front+1] + "\n");
                    } else {
                        bw.write(-1 + "\n");
                    }
                    break;

                case "back":
                    if(size != 0) {
                        bw.write(deque[back-1] + "\n");
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
