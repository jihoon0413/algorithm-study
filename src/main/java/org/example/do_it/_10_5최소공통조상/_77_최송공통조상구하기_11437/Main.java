package org.example.do_it._10_5최소공통조상._77_최송공통조상구하기_11437;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int[] depth;
    static int[] parent;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;

        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        parent = new int[N+1];
        depth = new int[N+1];
        for(int i = 0 ; i <= N ; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 2 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            list.get(parent).add(child);
            list.get(child).add(parent);
        }

        bfs(1);

        int M = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            while(a != b) {
                if(depth[a] == depth[b]) {
                    a = parent[a];
                    b = parent[b];
                } else if(depth[a] < depth[b]) {
                    b = parent[b];
                } else {
                    a = parent[a];
                }
            }
            System.out.println(a);

        }

    }
    static void bfs(int a) {
        Queue<int[]> que = new LinkedList<>();

        que.add(new int[] {a, 1});
        visited[a] = true;

        while(!que.isEmpty()) {
            int[] nowInfo = que.poll();
            int now = nowInfo[0];
            int d = nowInfo[1];

            for(int next : list.get(now)) {
                if(!visited[next]) {
                    visited[next] = true;
                    que.add(new int[] {next, d+1});
                    parent[next] = now;
                    depth[next] = d+1;
                }
            }
        }
    }
}
