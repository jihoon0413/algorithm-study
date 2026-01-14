package org.example.do_it._9_7최소신장트리._67_최소신장트리구하기_1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for(int i = 0 ; i <= N ; i++) {
            parent[i] = i;
        }

        PriorityQueue<Edge> edges = new PriorityQueue<>((o1, o2) -> {
            return o1.v - o2.v;
        });

        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges.add(new Edge(s,e,v));
        }

        while(!edges.isEmpty()) {
            Edge edge = edges.poll();

            int s = edge.s;
            int e = edge.e;

            if(find(s) != find(e)) {
                union(s,e);
                answer += edge.v;
            }
        }

        // for(int i = 1; i <= N ; i++) {
        //   System.out.print(parent[i] + " ");
        // }

        System.out.print(answer);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            parent[b] = a;
        }
    }

    static int find(int a) {
        if(parent[a] == a) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }

    static class Edge {
        int s,e,v;

        public Edge(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }
    }

}