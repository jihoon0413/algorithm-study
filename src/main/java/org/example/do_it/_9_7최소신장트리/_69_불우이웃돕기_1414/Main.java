package org.example.do_it._9_7최소신장트리._69_불우이웃돕기_1414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static PriorityQueue<Edge> edges = new PriorityQueue<>((o1,o2) -> {
        return o1.l - o2.l;
    });
    static int[] parent;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        int N = Integer.parseInt(br.readLine());

        int[][] list = new int[N][N];
        parent = new int[N];

        for(int i = 0 ; i < N ; i++) {
            String str = br.readLine();
            parent[i] =i;
            for(int j = 0 ; j < str.length() ; j++) {
                char c = str.charAt(j);
                if(c == '0') {
                    list[i][j] = 0;
                }
                else if(c >= 'a') {
                    list[i][j] = c - 'a' + 1;
                } else {
                    list[i][j] = c - 'A' + 27;
                }
            }
        }

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                answer += list[i][j];
                if(i != j && list[i][j] != 0) {
                    edges.add(new Edge(i,j,list[i][j]));
                }
            }
        }

        int useEdge = 0;
        while(!edges.isEmpty()) {
            Edge now = edges.poll();
            int s = find(now.s);
            int e = find(now.e);
            int l = now.l;

            if(s != e) {
                union(s,e);
                answer -= l;
                useEdge++;
            }
        }

        if(useEdge == N-1) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }

        // int first = find(parent[0]);
        // boolean flag = true;
        // for(int i = 1 ; i < N ; i++) {
        //   if(first != find(i)) {
        //     flag = false;
        //   }
        // }

        // if(flag) {
        //   System.out.println(answer);
        // } else {
        //   System.out.println(-1);
        // }

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

    static class Edge{
        int s,e,l;

        public Edge(int s, int e, int l) {
            this.s = s;
            this.e = e;
            this.l = l;
        }
    }
}
