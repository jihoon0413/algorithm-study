package org.example.do_it._9_4다익스트라._60_최소비용구하기_1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Edge>> list = new ArrayList<>();
    static boolean[] visited;
    static int[] result;
    static PriorityQueue<Edge> que = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];
        result = new int[N+1];

        for(int i = 0 ; i <= N ; i++) {
            result[i] = Integer.MAX_VALUE;
            list.add(new ArrayList<>());
        }

        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(s).add(new Edge(e,v));
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        result[S] = 0;
        que.add(new Edge(S,0));


        while(!que.isEmpty()) {
            Edge now = que.poll();
            int idx = now.vertex;

            if(visited[idx]) continue;
            visited[idx] = true;

            for(Edge next : list.get(idx)) {
                if(result[next.vertex] > result[idx] + next.value) {
                    result[next.vertex] = result[idx] + next.value;
                    que.add(new Edge(next.vertex ,result[next.vertex]));
                }
            }
        }

        System.out.println(result[E]);

    }

    static class Edge implements Comparable<Edge> {
        int vertex;
        int value;

        public Edge(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }

        public int compareTo(Edge o2) {
            return this.value - o2.value;
        }
    }
}

