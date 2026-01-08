package org.example.do_it._7_1그리디._36_카드정렬하기_1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long answer = 0;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<>();

        for(int i = 0 ; i < N ; i++) {
            que.add(Integer.parseInt(br.readLine()));
        }

        int a = 0;
        int b = 0;
        while(que.size() != 1) {
            a = que.poll();
            b = que.poll();
            answer += (a + b);
            que.add(a+b);
        }

        System.out.println(answer);

    }
}
