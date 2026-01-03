package org.example.do_it._4_5스택과큐._13_카드2_2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> que = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for(int i = 1 ; i <= N ; i++) {
            que.add(i);
        }

        while(que.size() != 1) {
            que.poll();
            que.add(que.poll());
        }

        System.out.println(que.poll());
    }
}