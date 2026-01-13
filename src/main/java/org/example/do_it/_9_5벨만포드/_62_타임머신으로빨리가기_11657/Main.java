package org.example.do_it._9_5벨만포드._62_타임머신으로빨리가기_11657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Edge> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] result = new long[N+1];
        for(int i = 0 ; i <= N ; i++) {
            result[i] = Integer.MAX_VALUE;
        }

        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.add(new Edge(a,b,c));
        }

        result[1] = 0;

        for(int i = 1 ; i < N ; i++) {
            for(Edge edge : list) {
                if(result[edge.start] != Integer.MAX_VALUE && result[edge.end] > result[edge.start] + edge.time) {
                    result[edge.end] = result[edge.start] + edge.time;
                }
            }
        }

        boolean isCycle = false;

        for(Edge edge : list) {
            if(result[edge.start] != Integer.MAX_VALUE && result[edge.end] > result[edge.start] + edge.time) {
                isCycle = true;
            }
        }

        if(isCycle) {
            System.out.print(-1);
        } else {
            for(int i = 2 ; i <= N ; i++) {
                if(result[i] == Integer.MAX_VALUE) {
                    System.out.println(-1);
                } else {
                    System.out.println(result[i]);
                }
            }
        }

    }

    static class Edge{
        int start;
        int end;
        int time;

        public Edge(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }
}

