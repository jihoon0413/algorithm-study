package org.example.do_it._7_1그리디._38_회의실배정_1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) -> {
            int a = o1[1] + o1[0];
            int b = o2[1] + o2[0];
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        boolean[] used = new boolean[24];

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            que.add(new int[] {a,b});
        }

        int last = 0;
        while(!que.isEmpty()) {
            int[] info = que.poll();
            int s = info[0];
            int e = info[1];
            if(last <= s) {
                answer++;
                last = e;
            }
        }
        System.out.println(answer);
    }
}

