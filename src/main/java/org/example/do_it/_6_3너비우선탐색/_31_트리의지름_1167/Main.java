package org.example.do_it._6_3너비우선탐색._31_트리의지름_1167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static List<List<Edge>> list = new ArrayList<>();
    static boolean[] visited;
    static int[] answer;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());


        for(int i = 0 ; i <= N ; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            while(true) {
                int a = Integer.parseInt(st.nextToken());
                if(a == -1) {
                    break;
                }
                int b = Integer.parseInt(st.nextToken());
                list.get(node).add(new Edge(a,b));
            }
        }

        visited = new boolean[N+1];
        answer = new int[N+1];
        bfs(1);

        int newNode = 1;
        for(int i = 2 ; i <= N ; i++) {
            if(answer[newNode] < answer[i]) {
                newNode = i;
            }
        }

        visited = new boolean[N+1];
        answer = new int[N+1];
        bfs(newNode);

        int result = 0;
        for(int a : answer) {
            result = Math.max(result, a);
        }

        System.out.println(result);
    }

    static void bfs(int s) {
        Queue<Integer> que = new LinkedList<>();

        que.add(s);
        visited[s] = true;

        while(!que.isEmpty()) {
            int node = que.poll();
            for(Edge edge : list.get(node)) {
                if(!visited[edge.goal]) {
                    visited[edge.goal] = true;
                    answer[edge.goal] = answer[node] + edge.value;
                    que.add(edge.goal);
                }
            }
        }
    }

    public static class Edge {
        int goal;
        int value;

        public Edge(int goal, int value) {
            this.goal=goal;
            this.value=value;
        }
    }
}