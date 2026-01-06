package org.example.do_it._6_3너비우선탐색._29_DFS와BFS_1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i <= N ; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for(int i = 0 ; i <= N ; i++) {
            Collections.sort(list.get(i));
        }

        visited = new boolean[N+1];
        dfs(V);
        System.out.println();

        visited = new boolean[N+1];
        bfs(V);
    }

    static void dfs(int a) {
        System.out.print(a + " ");

        visited[a] = true;
        for(int node : list.get(a)) {
            if(!visited[node]) {
                dfs(node);
            }
        }
    }

    static void bfs(int a) {
        Queue<Integer> que = new LinkedList<>();

        que.add(a);
        visited[a] = true;

        while(!que.isEmpty()) {
            int node = que.poll();
            System.out.print(node + " ");

            for(int temp : list.get(node)) {
                if(!visited[temp]) {
                    visited[temp] = true;
                    que.add(temp);
                }
            }
        }
    }
}
