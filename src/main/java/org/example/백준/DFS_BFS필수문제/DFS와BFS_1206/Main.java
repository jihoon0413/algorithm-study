package org.example.백준.DFS_BFS필수문제.DFS와BFS_1206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int V;
    static boolean[][] arr;
    static boolean[] check;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        arr = new boolean[N+1][N+1];
        check = new boolean[N+1];

        for(int i = 1 ; i <= M ; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = true;
        }
        
        sb = new StringBuilder();
        dfs(V);

        System.out.println(sb);

        for(int i = 1 ; i <= N; i++) {
            check[i] = false;
        }

        sb = new StringBuilder();
        bfs(V);


        System.out.println(sb);


    }

    static void dfs(int v) {

        sb.append(v).append(" ");
        check[v] = true;

        for(int i = 1 ; i <= N ; i++) {

            if(arr[v][i] && !check[i]) {
                dfs(i);
            }

        }
    }

    static void bfs(int v) {

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(v);
        check[v] = true;
        sb.append(v).append(" ");
        int val;

        while (!queue.isEmpty()) {

            val = queue.poll();
            for(int i = 1 ; i <= N ; i++) {
                if(arr[val][i] && !check[i]) {
                    sb.append(i).append(" ");
                    check[i] = true;
                    queue.add(i);
                }
            }

        }
    }
}
