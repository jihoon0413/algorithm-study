package org.example.백준.알고리즘기초_1_강의.자료구조1.큐_10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static int[] queue = new int[1000];
    static int first = 0;
    static int last = 0;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < a ; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String cmd = st.nextToken();

            switch(cmd) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    if(last - first == 0) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(pop()).append("\n");
                    }
                    break;

                case "size":
                    sb.append(size()).append("\n");
                    break;

                case "empty":
                    sb.append(empty()).append("\n");
                    break;

                case "front":
                    if(last - first == 0) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(front()).append("\n");
                    }
                    break;

                case "back":
                    if(last - first == 0) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(back()).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }

    public static void push(int X) {
        queue[last] = X;
        last++;
    }

    public static int pop() {
        if(last - first == 0) {
            return -1;
        }else {
            int P = queue[first];
            first++;
            return P;
        }
    }

    public static int size() {
        return last - first;
    }

    public static int empty() {
        if(last - first == 0) {
            return 1;
        }else {
            return 0;
        }
    }

    public static int front() {
        if(last - first == 0) {
            return -1;
        }else {
            int F = queue[first];
            return F;
        }
    }

    public static int back() {
        if(last - first == 0) {
            return -1;
        }else {
            int B = queue[last - 1];
            return B;
        }
    }

}
